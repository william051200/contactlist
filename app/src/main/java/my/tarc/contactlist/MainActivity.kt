package my.tarc.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import my.tarc.contactlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val contactList = ArrayList<Contact>()
    private var index = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnAdd.setOnClickListener {
            if (binding.txtName.text.isEmpty()) {
                binding.txtName.error = getString(R.string.nameError)
                return@setOnClickListener
            }

            if (binding.txtPhone.text.isEmpty()) {
                binding.txtPhone.error = getString(R.string.nameError)
                return@setOnClickListener
            }

            val newContact =
                Contact(binding.txtName.text.toString(), binding.txtPhone.text.toString())
            contactList.add(newContact)

            index = -1
            binding.txtResultName.setText("")
            binding.txtResultPhone.setText("")
        }

        binding.btnPrevious.setOnClickListener {
            if (contactList.size > 0 && index > 0) {
                index--
                showRecord(contactList.get(index))
            }
        }

        binding.btnNext.setOnClickListener {
            if (contactList.size >= 0 && index < contactList.size - 1) {
                index++
                showRecord(contactList.get(index))
            }
        }
    }

//    as

    private fun showRecord(contact: Contact) {
        binding.contact = contact
        binding.invalidateAll()
    }
}