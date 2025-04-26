package com.ascama.fonctionnalites.ui.screens

import android.util.Log
import android.widget.LinearLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.barteksc.pdfviewer.PDFView

@Composable
fun PDFReaderScreen(fileName: String) {
    AndroidView(
        modifier = Modifier
            .fillMaxSize(),
        factory = { context ->
            PDFView(context, null).apply {
              layoutParams = LinearLayout.LayoutParams(
                  LinearLayout.LayoutParams.MATCH_PARENT,
                  LinearLayout.LayoutParams.MATCH_PARENT
              )

                try {
                    fromAsset(fileName) // charger le fichier dans le repertoire assets
                        .enableSwipe(true) // activer le defilement des pages
                        .swipeHorizontal(false) // desactiver le defilement horizontal des pages
                        .defaultPage(0) // la page par defaut est la première page 0
                        .enableDoubletap(true) // activer le zommer par double click
                        .load() // charger et afficher le pdf
                } catch (e: Exception){
                    Log.e("PdfViewer", "Erreur de chargement du PDF : ${e.message}")
                }
            }
        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PDFReaderPreview() {
    
}