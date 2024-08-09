# Instrucciones Paso a Paso de Ejecución

## Requisitos Previos
1. Tener instalado Java JDK 21.0.2 o superior.
2. Tener Maven instalado y configurado en el PATH.
3. Tener Google Chrome instalado.
4. Tener configurado el ChromeDriver compatible con la versión de Chrome instalada.
5. Tener un IDE como Visual Studio Code o IntelliJ IDEA.

## Pasos para la Ejecución del Proyecto

1. **Clonar el Proyecto:**
Clona el repositorio del proyecto en tu máquina local.

2. **Configurar las Dependencias:**
Asegurate tener las dependencias necesarias para ejecutar `src\test\java`.

3. **Ejecución de las Pruebas:**
Ejecuta las pruebas dando clic en el botón verde con forma de flecha apuintando a la derecha o simbolo de "play".

Esto ejecutará las pruebas automatizadas en el flujo de compra de la página `https://www.saucedemo.com/`.

4. **Ver el Reporte:**
Al finalizar la ejecución de las pruebas, se generará un reporte HTML en la raíz del proyecto con el nombre `extentReports.html`.

Para abrir el reporte, localiza el archivo en el explorador de archivos y ábrelo con tu navegador web preferido (Chrome, Firefox, etc.).

## Detalles Adicionales

- **Configuración de ChromeDriver:**
Asegúrate de que el ChromeDriver esté en el PATH o en el directorio del proyecto para que sea reconocido durante la ejecución.

- **Modificaciones del Código:**
Si necesitas ajustar el código, edita los archivos en la carpeta `src\test\java`.

## Solución de Problemas

- Si la prueba falla, revisa el reporte `extentReports.html` para detalles sobre la causa del fallo.
- Asegúrate de que la versión de ChromeDriver coincida con la versión instalada de Google Chrome.

