package com.ascama.fonctionnalites.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.jstarczewski.pc.mathview.src.MathView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulesScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Formules Physique & Chimie") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                Text("Équations de Maxwell :", style = MaterialTheme.typography.titleMedium)
                EquationView(latex = "∇·E = ρ / ε₀")
                EquationView(latex = "∇×B = μ₀J")
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text("Autres formules utiles :", style = MaterialTheme.typography.titleMedium)
                EquationView(latex = "F = m·a")
                EquationView(latex = "V = I·R")
                EquationView(latex = "P = U·I")
                EquationView(latex = "E = m·c²")
            }

            item {
                EquationView(latex = "V = I·R")            // Loi d'Ohm
                EquationView(latex = "P = U·I")            // Puissance électrique
                EquationView(latex = "E = P·t")            // Énergie électrique
                EquationView(latex = "R_{eq} = R_1 + R_2 + R_3")      // Résistances en série
                EquationView(latex = "1/R_{eq} = 1/R_1 + 1/R_2 + 1/R_3") // Résistances en parallèle

            }

            item {
                EquationView(latex = "v = d / t")           // Vitesse
                EquationView(latex = "a = Δv / Δt")         // Accélération
                EquationView(latex = "F = m·a")             // Deuxième loi de Newton
                EquationView(latex = "P = F / S")           // Pression (mécanique)
                EquationView(latex = "W = F·d")             // Travail
                EquationView(latex = "P = W / t")           // Puissance mécanique

            }

            item {
                EquationView(latex = "n = c / v")            // Indice de réfraction
                EquationView(latex = "1/f = 1/d_o + 1/d_i")  // Formule des lentilles
                EquationView(latex = "c = λ·f")              // Vitesse de la lumière

            }

            item {
                EquationView(latex = "n = m / M")            // Quantité de matière
                EquationView(latex = "C = n / V")            // Concentration molaire
                EquationView(latex = "m = C·V·M")            // Masse à partir de concentration
                // Vitesse de la lumière

            }

            item {
                EquationView(latex = "\\frac{m}{M}")             // Quantité de matière
                EquationView(latex = "\\frac{1}{R} = \\frac{1}{R_1} + \\frac{1}{R_2}") // Résistance en parallèle
                EquationView(latex = "\\frac{\\Delta v}{\\Delta t}") // Accélération
                EquationView(latex = "F = m \\cdot a")
                EquationView(latex = "E = m \\cdot c^2")
                EquationView(latex = "\\frac{m}{M}")
                EquationView(latex = "n = m / M")  // Ajout de 'n =' pour la quantité de matière
                // Avec la syntaxe LaTeX complète CORRIGÉE

            }
            item {
                EquationView(latex = "n = m / M")  // Propre et fiable
                EquationView(latex = "1/R_{eq} = 1/R_1 + 1/R_2")
                EquationView(latex = "a = Δv/Δt")  // Forme compacte




            }

            item {
                EquationView(latex = "H_2 + Cl_2 \\to H_2O")          // \to (version courte)
                EquationView(latex = "A \\longrightarrow B")          // flèche longue
                EquationView(latex = "A \\Rightarrow B")              // flèche logique
                EquationView(latex = "A \\xrightarrow{Δ} B")          // avec texte au-dessus
                EquationView(latex = "CH₄ + 2 O₂ → CO₂ + 2 H₂O")      // flèche Unicode →
                EquationView(latex = "N₂ + 3 H₂ ⇌ 2 NH₃")             // équilibre Unicode ⇌

                EquationView(latex = "2\\,H_2 + O_2 \\rightarrow 2\\,H_2O")

                // Équilibre chimique
                EquationView(latex = "N_2\\,(g) + 3\\,H_2\\,(g) \\rightleftharpoons 2\\,NH_3\\,(g)")
            }
        }
    }
}

@Composable
fun EquationView(latex: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
    ) {
        MathViewComposable(
            formula = latex,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun MathViewComposable(
    formula: String,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    AndroidView(
        modifier = modifier,
        factory = { ctx ->
            MathView(ctx).apply {
                text = "$$${formula}$$"  // PAS de $$ ni de \[...\]
                textColor = "#000000"
                textZoom = 120
            }
        }
    )
}
