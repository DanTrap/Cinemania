package com.dantrap.cinemania.fintech.core.domain.usecase

import com.dantrap.cinemania.fintech.core.domain.repository.AppReviewManager

class RateUsUseCase(private val appReviewManager: AppReviewManager) {

    operator fun invoke() = appReviewManager.reviewApplication()
}
