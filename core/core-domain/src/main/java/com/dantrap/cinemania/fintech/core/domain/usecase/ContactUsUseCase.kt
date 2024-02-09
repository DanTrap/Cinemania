package com.dantrap.cinemania.fintech.core.domain.usecase

import com.dantrap.cinemania.fintech.core.domain.repository.ContactUsManager

class ContactUsUseCase(private val contactUsManager: ContactUsManager) {

    operator fun invoke() = contactUsManager.contactUs()
}
