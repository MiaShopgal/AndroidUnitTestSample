package evan.chen.tutorial.tdd.androidunittestsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val id = intent.getStringExtra("ID")

    }
}
