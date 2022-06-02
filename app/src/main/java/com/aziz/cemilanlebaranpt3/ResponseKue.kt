package com.aziz.cemilanlebaranpt3

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseKue(

	@Json(name="kuekering")
	val kuekering: List<KuekeringItem?>? = null,

	@Json(name="kuebasah")
	val kuebasah: List<KuebasahItem?>? = null
) : Parcelable

@Parcelize
data class KuekeringItem(

	@Json(name="namakue")
	val namakue: String? = null,

	@Json(name="gambar")
	val gambar: String? = null,

	@Json(name="resep")
	val resep: String? = null,

	@Json(name="caramasak")
	val caramasak: String? = null,

	@Json(name="desc")
	val desc: String? = null
) : Parcelable

@Parcelize
data class KuebasahItem(

	@Json(name="namakue")
	val namakue: String? = null,

	@Json(name="gambar")
	val gambar: String? = null,

	@Json(name="resep")
	val resep: String? = null,

	@Json(name="caramasak")
	val caramasak: String? = null,

	@Json(name="desc")
	val desc: String? = null
) : Parcelable
