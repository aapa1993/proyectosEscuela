const apiKey =
  "0e64ff346f72427b728428f544153239a2bdbe6e5bc3c7d06ce0a8b931ec60b7";

const getElement = (id) => document.getElementById(id);

const updateResult = (content, display = true) => {
  const result = document.getElementById("result");
  result.style.display = display ? "block" : "none";
  result.innerHTML = content;
};

const showLoading = (message) =>
  updateResult(`
    <div class="loading">
        <p>${message}</p>
        <div class="spinner"></div>
    </div>
`);

const showError = (message) => updateResult(`<p class="error">${message}</p>`);

//API REQUEST
async function makeRequest(url, options = {}) {
  const response = await fetch(url, {
    ...options,
    headers: {
      "x-apikey": apiKey,
      ...options.headers,
    },
  });

  //Handle failed requests
  if (!response.ok) {
    const error = await response
      .json()
      .catch(() => ({ error: { message: response.statusText } }));
    throw new Error(error.error?.message || "Request Failed!");
  }

  return response.json();
}

//Scanning URL
async function scanURL() {
  const url = getElement("url").value.trim();
  if (!url) return showError("Please enter a URL!");

  try {
    new URL(url); //Validate url format
  } catch {
    return showError("Please enter a valid URL (e.g https//example.com)");
  }

  try {
    showLoading("Submitting URL for scanning...");

    const encodedURL = encodeURIComponent(url);

    //Submit URL to virustotal
    const submitResult = await makeRequest(
      "https://www.virustotal.com/api/v3/urls",
      {
        method: "POST",
        headers: {
          accept: "application/json",
          "content-type": "application/x-www-form-urlencoded",
        },
        body: `url=${encodedURL}`,
      }
    );

    if (!submitResult.data?.id) {
      throw new Error("Failed to get analysis ID");
    }

    await new Promise((resolve) => setTimeout(resolve, 3000));

    showLoading("Getting scan results...");
    await pollAnalysisResults(submitResult.data.id);
  } catch (error) {
    showError(`Error: ${error.message}`);
  }
}

//Scanning a file
async function scanFile() {
  const file = getElement("file").files[0];
  if (!file) return showError("Please select a file!");
  if (file.size > 32 * 1024 * 1024)
    return showError("File size exceeds 32MB limit.");

  try {
    showLoading("Uploading file...");

    const formData = new FormData();
    formData.append("file", file);

    //Uploading file to virustotal
    const uploadResult = await makeRequest(
      "https://www.virustotal.com/api/v3/files",
      {
        method: "POST",
        body: formData,
      }
    );

    if (!uploadResult.data?.id) {
      throw new Error("Failed to get file ID");
    }

    await new Promise((resolve) => setTimeout(resolve, 3000));

    showLoading("Getting scan results...");
    const analysisResult = await makeRequest(`https://www.virustotal.com/api/v3/analyses/${uploadResult.data.id}`);

    if(!analysisResult.data?.id){
      throw new Error("Failed to get analysis results!");
    }

    await pollAnalysisResults(analysisResult.data.id, file.name);
  } catch (error) {
    showError(`Error: ${error.message}`);
  }
}
