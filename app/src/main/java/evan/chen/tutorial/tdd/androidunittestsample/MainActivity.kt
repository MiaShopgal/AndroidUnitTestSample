package evan.chen.tutorial.tdd.androidunittestsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.v7.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send.setOnClickListener {

            val loginId = loginId.text.toString()
            val pwd = password.text.toString()

            val isLoginIdOK = RegisterVerify().isLoginIdVerify(loginId)

            var isPwdOK = false
            //密碼至少8碼，第1碼為英文，並包含1碼數字
            if (pwd.length >= 8) {
                if (pwd.toUpperCase().first() in 'A'..'Z') {
                    if (pwd.findAnyOf((0..9).map { it.toString() }) != null) {
                        isPwdOK = true
                    }
                }
            }

            if (!isLoginIdOK) {
                // 註冊失敗，資料填寫錯誤
                val builder = AlertDialog.Builder(this)

                builder.setMessage("帳號至少要6碼，第1碼為英文")
                    .setTitle("錯誤")

                builder.show()
            }

            else if (!isPwdOK) {
                // 註冊失敗，資料填寫錯誤
                val builder = AlertDialog.Builder(this)

                builder.setMessage("密碼至少要8碼，第1碼為英文，並包含1碼數字")
                    .setTitle("錯誤")

                builder.show()
            } else {
                // 導至註冊成功頁
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("ID", loginId)

                startActivity(intent)
            }
        }
    }
}
