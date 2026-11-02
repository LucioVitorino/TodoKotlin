package ao.co.isptec.aplm.todokotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var campoTarefa: EditText;
    private lateinit var botaoAdicionar: Button;
    private lateinit var listaTarefas: ListView;
    private val tarefas = mutableListOf<Tarefa>();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        campoTarefa = findViewById<EditText>(R.id.campoTarefa);
        botaoAdicionar = findViewById<Button>(R.id.botaoAdicionar);
        listaTarefas = findViewById<ListView>(R.id.listaTarefas);

        botaoAdicionar.setOnClickListener {
            val texto = campoTarefa.text.toString();
            if (texto.isBlank())
                campoTarefa.error = "Introduza uma tarefa"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}