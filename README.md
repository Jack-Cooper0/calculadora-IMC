# ⚔️ Calculadora IMC Vikinga — Valhalla IMC 🛡️

![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android_Studio-2026.1-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-Material3-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

Una aplicación nativa para Android desarrollada con **Jetpack Compose** y **Material 3**, diseñada con una temática épica vikinga para calcular el Índice de Masa Corporal (IMC) de los guerreros de Valhalla.

---

## 🪓 Características Destacadas

- 🎨 **Diseño & Tema Vikingo Personalizado**:
  - Paleta de colores inspirada en oro nórdico (`#D4AF37`), cuero, madera oscura y pergamino.
  - Tarjetas con bordes dorados grabados y símbolos rúnicos (`ᛏ VALHALLA IMC ᛏ`).
  - Compatibilidad completa con modo oscuro y *Edge-to-Edge* de Android.
- 👤 **Dades del Guerrer**: Entrada interactiva para el nombre del guerrero/a.
- 🛡️ **Control de Pes (Massa de batalla)**: Ajuste fino con botones interactivos de peso en kilogramos (*-1 kg* / *+1 kg*).
- 🏹 **Control d'Alçada (Estatura)**: Deslizador (*Slider*) fluido para seleccionar la altura en centímetros.
- ⚡ **Forja del IMC**: Cálculo preciso en tiempo real mediante la fórmula estándar:
  $$\text{IMC} = \frac{\text{Pes (kg)}}{\text{Alçada (m)}^2}$$
- 🔥 **Verdicte dels Déus (Resultados)**:
  - ❄️ **Guerrer d'Hivern** (*Pes insuficient* - $\text{IMC} < 18.5$)
  - ⚔️ **Digne de Valhalla!** (*Pes ideal* - $18.5 \le \text{IMC} < 25.0$)
  - 🛡️ **Força de Berserker!** (*Sobrepes* - $25.0 \le \text{IMC} < 30.0$)
  - 🌋 **Gegant de Gel (Jötunn)** (*Obesitat* - $\text{IMC} \ge 30.0$)

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose) con **Material 3**
- **Arquitectura**: Componentes de arquitectura moderna de Android (`ComponentActivity`, `Scaffold`, Estados reactivos de Compose)
- **Gestión de Dependencias**: Gradle Version Catalog (`libs.versions.toml`)
- **Compilador Kotlin / Compose Plugin**: 2.2.x

---

## 🚀 Requisitos e Instalación

### Requisitos previos:
- **Android Studio**: Ladybug / 2024.2+ o posterior.
- **JDK**: Java 11 o superior.
- **Dispositivo / Emulador**: Android 7.0 (API Nivel 24) o superior.

### Pasos para ejecutar:
1. **Clonar el repositorio**:
   ```bash
   git clone https.github.com/Jack-Cooper0/calculadora-IMC.git
   cd calculadora-IMC
   ```
2. **Abrir en Android Studio**:
   - Abre Android Studio y selecciona `Open an Existing Project`.
   - Selecciona la carpeta raíz del proyecto.
3. **Ejecutar la app**:
   - Conecta un dispositivo físico o inicia un emulador.
   - Presiona `Run` (`Shift + F10`) o despliega con Gradle:
     ```bash
     ./gradlew assembleDebug
     ```

---

## 📁 Estructura del Proyecto

```text
imcJC/
├── app/
│   └── src/
│       └── main/
│           ├── java/org/insbaixcamp/imcjc/
│           │   ├── MainActivity.kt          # Pantalla principal BMIScreen y lógica de cálculo
│           │   └── ui/theme/
│           │       ├── Color.kt             # Paleta de colores vikinga (VikingGold, VikingSurface, etc.)
│           │       ├── Theme.kt             # Configuración del esquema de color VikingColorScheme
│           │       └── Type.kt              # Tipografía de la aplicación
│           └── AndroidManifest.xml
├── gradle/
│   └── libs.versions.toml                   # Catálogo de versiones de dependencias
├── build.gradle.kts                         # Configuración raíz de Gradle
├── README.md                                # Documentación del proyecto
└── settings.gradle.kts
```

---

## 📜 Licencia

Proyecto desarrollado para fines educativos.
Siente la fuerza del fuego de la forja y ¡que Odín guíe tus pasos! ⚡⚔️
