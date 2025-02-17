//Definiendo variables
const body = document.body;
const card = document.getElementById("card");
const commentInput = document.getElementById("commentInput");
const addButton = document.getElementById("add-button");
const cancelButton = document.getElementById("cancel");
const reverseCapybara = document.getElementById("reverse");

//Mostrar el card del comentario
reverseCapybara.addEventListener("click", () => {
  card.style.display = "block";
  commentInput.focus();
});

//Cerrar el card
cancelButton.addEventListener("click", () => {
  card.style.display = "none";
  commentInput.value = "";
});

//Guarda los mensajes en un localStorage
window.addEventListener("load", function () {
  const storedComments = JSON.parse(localStorage.getItem("comments")) || [];
  storedComments.forEach((comment) => createBubble(comment));
  
  // Limpiar LocalStorage al cargar la página
  localStorage.removeItem("comments");
});

//Mostrar el otro capibara
addButton.addEventListener("mouseover", () => {
  reverseCapybara.style.display = "block";

  reverseCapybara.addEventListener("mouseout", () => {
    addButton.style.display = "block";
    reverseCapybara.style.display = "none";
  });
});

//Enviar comentario
function submitComment() {
  const comment = commentInput.value.trim();
  if (comment) {
    createBubble(comment);
    card.style.display = "none";
    commentInput.value = "";
    lanzarConfetti();

    //Comentarios aparecerán incluso cuando se recargue la página
    const storedComments = JSON.parse(localStorage.getItem("comments")) || [];
    storedComments.push(comment);
    localStorage.setItem("comments", JSON.stringify(storedComments));
  }
}

// Función para disparar confetti
function lanzarConfetti() {
  confetti({
    particleCount: 200, // Número de partículas
    spread: 70,
    origin: { y: 0.6 },
  });
}

// Permitir enviar con Enter
commentInput.addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    submitComment();
  }
});

//Cuadro de comentario
function createBubble(text) {
  const bubble = document.createElement("div");
  bubble.className = "bubble";

  // Crear el ícono de mensaje
  const icon = document.createElement("div");
  icon.className = "message-icon";
  icon.innerHTML = `
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <path d="M21 11.5a8.38 8.38 0 0 1-.9 3.8 8.5 8.5 0 0 1-7.6 4.7 8.38 8.38 0 0 1-3.8-.9L3 21l1.9-5.7a8.38 8.38 0 0 1-.9-3.8 8.5 8.5 0 0 1 4.7-7.6 8.38 8.38 0 0 1 3.8-.9h.5a8.48 8.48 0 0 1 8 8v.5z"/>
        </svg>
    `;

  // Crear el contenedor del comentario
  const comment = document.createElement("div");
  comment.className = "comment";
  comment.textContent = text;

  bubble.appendChild(icon);
  bubble.appendChild(comment);

  // Posición inicial
  const x = Math.random() * 80 + 10; // 10-90%
  const y = 100;
  bubble.style.left = `${x}%`;
  bubble.style.bottom = `${y}%`;

  // Velocidad aleatoria
  const speed = 2 + Math.random() * 1;

  body.appendChild(bubble);

  // Animación
  let currentY = y;

  function animate() {
    currentY -= speed * 0.1;

    if (currentY > -30) {
      bubble.style.bottom = `${currentY}%`;
      bubble.style.transform = `translateX(-50%) rotate(${
        Math.sin(currentY / 10) * 5
      }deg)`;
      requestAnimationFrame(animate);
    } else {
      setTimeout(() => {
        // Reinicia la posición
        currentY = y;
        bubble.style.bottom = `${currentY}%`;

        const newX = Math.random() * 80 + 2;
        bubble.style.left = `${newX}%`;

        requestAnimationFrame(animate);
      }, 3000);
    }
  }

  requestAnimationFrame(animate);
}

//Animation On Screen al recargar la página
AOS.init({
  once: true,
});
