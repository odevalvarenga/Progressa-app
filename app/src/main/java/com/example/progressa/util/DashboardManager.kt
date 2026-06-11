package com.example.progressa.util

import android.content.Context

object DashboardManager {

    private const val PREFS = "DASHBOARD"

    // ==========================
    // TEMPO ESTUDADO (SEGUNDOS)
    // ==========================

    fun salvarTempo(
        context: Context,
        segundos: Int
    ) {

        val prefs =
            context.getSharedPreferences(
                PREFS,
                Context.MODE_PRIVATE
            )

        val atual =
            prefs.getInt(
                "TEMPO",
                0
            )

        prefs.edit()
            .putInt(
                "TEMPO",
                atual + segundos
            )
            .apply()
    }

    fun getTempo(
        context: Context
    ): Int {

        return context
            .getSharedPreferences(
                PREFS,
                Context.MODE_PRIVATE
            )
            .getInt(
                "TEMPO",
                0
            )
    }

    // ==========================
    // HIDRATAÇÃO
    // ==========================

    fun salvarAgua(
        context: Context,
        agua: Int
    ) {

        context.getSharedPreferences(
            PREFS,
            Context.MODE_PRIVATE
        )
            .edit()
            .putInt(
                "AGUA",
                agua
            )
            .apply()
    }

    fun getAgua(
        context: Context
    ): Int {

        return context
            .getSharedPreferences(
                PREFS,
                Context.MODE_PRIVATE
            )
            .getInt(
                "AGUA",
                0
            )
    }

    // ==========================
    // LEITURA
    // ==========================

    fun salvarLivros(
        context: Context,
        livros: Int
    ) {

        context.getSharedPreferences(
            PREFS,
            Context.MODE_PRIVATE
        )
            .edit()
            .putInt(
                "LIVROS",
                livros
            )
            .apply()
    }

    fun getLivros(
        context: Context
    ): Int {

        return context
            .getSharedPreferences(
                PREFS,
                Context.MODE_PRIVATE
            )
            .getInt(
                "LIVROS",
                0
            )
    }

    // ==========================
    // MÉDIA DAS MATÉRIAS
    // ==========================

    fun salvarMedia(
        context: Context,
        media: Float
    ) {

        context.getSharedPreferences(
            PREFS,
            Context.MODE_PRIVATE
        )
            .edit()
            .putFloat(
                "MEDIA",
                media
            )
            .apply()
    }

    fun getMedia(
        context: Context
    ): Float {

        return context
            .getSharedPreferences(
                PREFS,
                Context.MODE_PRIVATE
            )
            .getFloat(
                "MEDIA",
                0f
            )
    }

    // ==========================
    // RESET DASHBOARD
    // ==========================

    fun limparDashboard(
        context: Context
    ) {

        context.getSharedPreferences(
            PREFS,
            Context.MODE_PRIVATE
        )
            .edit()
            .clear()
            .apply()
    }
}