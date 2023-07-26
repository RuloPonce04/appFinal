package com.example.prototipo1.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.prototipo1.R
import android.widget.Button
import android.widget.ListView
import com.example.prototipo1.databinding.ActivityDiapositivasBinding
import com.github.barteksc.pdfviewer.PDFView

class Diapositivas : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var pdfView: PDFView
    private lateinit var btnLoadPdf: Button // Agrega la declaración del botón

    companion object {
        const val PICK_PDF_FILE = 2
    }

    private lateinit var mBinding: ActivityDiapositivasBinding
    private lateinit var sesiones: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityDiapositivasBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        pdfView = findViewById(R.id.pdfView)
        btnLoadPdf = findViewById(R.id.btnLoadPdf) // Inicializa el botón

        sesiones = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item)
        sesiones.addAll("Sesion 1", "Sesion 2", "Sesion 3", "Sesion 4", "Sesion 5", "Sesion 6", "Sesion 7", "Sesion 8")
        mBinding.SeleccionSesiones.adapter = sesiones
        mBinding.SeleccionSesiones.onItemSelectedListener = this

        // Configura el clic del botón para cargar el PDF desde la carpeta "assets"
        btnLoadPdf.setOnClickListener {
            loadPdfFromAssets()
        }
    }

    // Función para cargar el archivo PDF desde la carpeta "assets" y mostrarlo en el PDFView
    private fun loadPdfFromAssets() {
        val sesionSeleccionada = mBinding.SeleccionSesiones.selectedItem.toString()
        val pdfFileName = "curso_android_sesion" + sesionSeleccionada.replace("Sesion ", "") + ".pdf"
        pdfView.fromAsset(pdfFileName).load()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Puedes dejar este método vacío si no necesitas realizar ninguna acción al seleccionar una sesión.
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Puedes dejar este método vacío si no necesitas realizar ninguna acción cuando no se ha seleccionado ninguna sesión.
    }
}