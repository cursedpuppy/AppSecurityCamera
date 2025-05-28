⚠️Por favor leer notas al final⚠️

**Security Camera IA - Componente Móvil**  
*(Complemento Educativo del Sistema de Vigilancia Inteligente)*  

---

### **Descripción Técnica de la Aplicación Android**  
Esta aplicación complementa el sistema central de detección (DetecciónPersonasArduino), demostrando la integración práctica entre:  
- **Procesamiento en Edge** (Python/OpenCV)  
- **Cloud Services** (Firebase Firestore/Storage)  
- **Visualización Móvil** (Android SDK)  

**Funcionalidad Clave**:  
```java
// Conexión con Firestore para recuperar detecciones
Query query = db.collection("detections").whereEqualTo("correo", correo.toLowerCase());
FirestoreRecyclerOptions<Images> options = new FirestoreRecyclerOptions.Builder<Images>()
    .setQuery(query, Images.class)
    .build();
```
- Consulta filtrada por correo electrónico  
- Actualización en tiempo real con `FirestoreRecyclerAdapter`  
- Renderizado eficiente con `RecyclerView` y Picasso  

---

### **Flujo de Datos Integrado**  
1. **Detección (Python)**:  
   - YOLOv8 identifica personas → Almacena en Firestore  
   ```python
   detections_ref.add({
       'timestamp': int(time.time()),
       'correo': email_receiver,
       'imageUrl': image_url,
   })
   ```

2. **Consulta (Android)**:  
   - Búsqueda por correo → Recupera registros históricos  
   ```java
   searchButton.setOnClickListener(view -> searchImagesByEmail());
   ```

3. **Visualización**:  
   - Muestra imágenes con metadatos usando patrón ViewHolder  
   ```java
   public class ImageViewHolder extends RecyclerView.ViewHolder {
       public void bindData(Images model) {
           Picasso.get().load(model.getImageUrl()).into(imageView);
       }
   }
   ```

---

### **Arquitectura Técnica**  
| Capa | Tecnologías | Función |  
|------|-------------|---------|  
| **Frontend** | Android SDK, Material Design | Interfaz de consulta y visualización |  
| **Backend** | Firebase Firestore, Storage | Almacenamiento estructurado de alertas |  
| **Comunicación** | FirestoreRecyclerAdapter, Picasso | Sincronización y carga de imágenes |  

---

### **Limitaciones Técnicas (Propósito Educativo)**  
- Interfaz mínima funcional (`EditText` + `RecyclerView`)  
- Ausencia de autenticación avanzada  
- Optimización básica de caché de imágenes  
- Manejo elemental de errores en consultas  

---

### **Equipo de Desarrollo**  
- **Líder Técnico**: Vicente Scheihing (Arquitectura de Integración y desarrollo de la Aplicación Android)  

---

**Propósito del Código**:  
Demostrar habilidades en:  
- Integración multiplataforma (Python-Android)  
- Consumo de APIs en tiempo real  
- Manejo de datos no estructurados  

*Nota: Código compartido con fines pedagógicos - Requiere mejoras para uso productivo*

⚠️Nota importante: Este proyecto no funciona porque las credenciales de Firebase fueron expuestas públicamente y deshabilitadas por seguridad. Usa tus propias credenciales de Firebase para probarlo localmente.⚠️
