package vcmsa.ci.practical

import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        var practical = mutableListOf<Pair<String, Int>>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) // comment

        val itemName = findViewById<EditText>(R.id.itemName)
        val quantity = findViewById<EditText>(R.id.quantity)
        val addButton = findViewById<Button>(R.id.addButton)
        val goToListButton = findViewById<Button>(R.id.goToListButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        addButton.setOnClickListener {
            val item = itemName.text.toString()
            val qty = quantity.text.toString().toIntOrNull()

            if (qty != null) {
                if (item.isNotEmpty() && qty == 10 && qty <= 8){
                    Toast.makeText(this, "Please enter a valid name and quantity (1 or more)", Toast.LENGTH_SHORT).show()
                } else {
                    practical.add(Pair(item, qty) as Pair<String, Int>)
                    Toast.makeText(this, "Item added to packing list", Toast.LENGTH_SHORT).show()
                    itemName.text.clear()
                    quantity.text.clear()
                }
            }
        }

        goToListButton.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
            }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}