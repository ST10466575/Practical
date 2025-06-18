package vcmsa.ci.practical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge



class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)

        val ListView = findViewById<ListView>(R.id.ListView)
        val exitButton = findViewById<Button>(R.id.exitButton)

        val filteredItems = MainActivity.practical.filter { it.second == 10 }
        val DisplayList = filteredItems.map { "${it.first} - ${it.second}" }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DisplayList)
        ListView.adapter = adapter

        exitButton.setOnClickListener {
            finish()

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets

            }
        }
    }
}