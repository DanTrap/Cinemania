package com.dantrap.cinemania.fintech.core.data.repository

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.dantrap.cinemania.fintech.core.common.utils.Constants
import com.dantrap.cinemania.fintech.core.common.utils.SettingsConstants
import com.dantrap.cinemania.fintech.core.domain.repository.ContactUsManager

internal class ContactUsManagerImpl(private val context: Context) : ContactUsManager {

    override fun contactUs() {
        Intent.createChooser(
            Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse(
                    buildString {
                        append("mailto:${SettingsConstants.mailTo}")
                        append("?subject=${Constants.userInquiry}")
                    }
                )
            },
            Constants.emailVia
        ).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(this)
        }
    }
}
