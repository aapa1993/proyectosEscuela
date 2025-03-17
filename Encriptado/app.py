import tkinter as tk
from tkinter import messagebox

alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ 09215637984°|!#$%&/()=?¡'¿+}´{-.,"

# Función de cifrado César
def cifrarTexto(texto, desplazamiento):
    textoMayuscula = texto.upper()
    textoCifrado = ""

    for i in textoMayuscula:
        if i in alfabeto:
            nuevo_indice = (alfabeto.index(i) + desplazamiento) % len(alfabeto)
            textoCifrado += alfabeto[nuevo_indice]
        else:
            textoCifrado += i  

    return textoCifrado


# Función de descifrado César
def descifrarTexto(texto, desplazamiento):
    textoMayuscula = texto.upper()
    textoDescifrado = ""

    for i in textoMayuscula:
        if i in alfabeto:
            nuevo_indice = (alfabeto.index(i) - desplazamiento) % len(alfabeto)
            textoDescifrado += alfabeto[nuevo_indice]
        else:
            textoDescifrado += i  

    return textoDescifrado

# Función para encriptar el texto ingresado
def encriptar():
    texto = entryTexto.get()
    try:
        desplazamiento = int(entryDesplazamiento.get())
        if texto:
            resultado = cifrarTexto(texto, desplazamiento)
            labelResultado.config(text=f"Texto encriptado: {resultado}")
        else:
            messagebox.showwarning("Entrada vacía", "Por favor, ingresa un texto para encriptar.")
    except ValueError:
        messagebox.showerror("Error", "Por favor, ingresa un número válido para el desplazamiento.")

# Función para desencriptar el texto ingresado
def desencriptar():
    texto = labelResultado.cget("text").replace("Texto encriptado: ", "")
    try:
        desplazamiento = int(entryDesplazamiento.get())
        if texto and "Texto encriptado" in labelResultado.cget("text"):
            resultado = descifrarTexto(texto, desplazamiento)
            labelResultado.config(text=f"Texto desencriptado: {resultado}")
        else:
            messagebox.showwarning("Error", "Primero encripta un texto antes de desencriptar.")
    except ValueError:
        messagebox.showerror("Error", "Por favor, ingresa un número válido para el desplazamiento.")


#Interfaz Gráfica
ventana = tk.Tk()
ventana.title("Programa de Encriptado y Desencriptado")

labelTexto = tk.Label(ventana, text="Ingresa el texto:")
labelTexto.grid(row=0, column=0, padx=10, pady=10)

labelDesplazamiento = tk.Label(ventana, text="Ingresa el desplazamiento (número):")
labelDesplazamiento.grid(row=1, column=0, padx=10, pady=10)

labelResultado = tk.Label(ventana, text="Resultado:")
labelResultado.grid(row=3, column=0, columnspan=2, padx=10, pady=10)

entryTexto = tk.Entry(ventana, width=40)
entryTexto.grid(row=0, column=1, padx=10, pady=10)

entryDesplazamiento = tk.Entry(ventana, width=40)
entryDesplazamiento.grid(row=1, column=1, padx=10, pady=10)

botonEncriptar = tk.Button(ventana, text="Encriptar", command=encriptar)
botonEncriptar.grid(row=2, column=0, padx=10, pady=10)

botonDesencriptar = tk.Button(ventana, text="Desencriptar", command=desencriptar)
botonDesencriptar.grid(row=2, column=1, padx=10, pady=10)

ventana.mainloop()
