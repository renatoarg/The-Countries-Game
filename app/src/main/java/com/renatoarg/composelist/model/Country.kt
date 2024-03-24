package com.renatoarg.composelist.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CountryItem (
    val name: Name,
    val tld: List<String>,
    val cca2: String,
    val ccn3: String,
    val cca3: String,
    val cioc: String? = null,
    val independent: Boolean,
    val unMember: Boolean,
    val currencies: Currencies,
    val idd: Idd,
    val capital: List<String>,
    val altSpellings: List<String>,
    //val region: Region,
    val subregion: String,
    val languages: Map<String, String>,
    val translations: Map<String, Translation>,
    val latlng: List<Double>,
    val landlocked: Boolean,
    val area: Double,
    val demonyms: Demonyms,
    val flag: String,
    val maps: Maps,
    val population: Long,
    val gini: Map<String, Double>? = null,
    val fifa: String? = null,
    //val car: Car,
    val timezones: List<String>,
    //val continents: List<Region>,
    val flags: Flags,
    val coatOfArms: CoatOfArms,
    //val startOfWeek: StartOfWeek,
    val capitalInfo: CapitalInfo,
    val postalCode: PostalCode? = null,
    val borders: List<String>? = null
)

@Serializable
data class CapitalInfo (
    val latlng: List<Double>
)

//@Serializable
//data class Car (
//    val signs: List<String>,
//    val side: Side
//)

@Serializable
enum class Side(val value: String) {
    Left("left"),
    Right("right");

    @Serializable
    companion object {

        public fun fromValue(value: String): Side = when (value) {
            "left"  -> Left
            "right" -> Right
            else    -> throw IllegalArgumentException()
        }
    }
}

@Serializable
data class CoatOfArms (
    val png: String? = null,
    val svg: String? = null
)

//@Serializable
//enum class Region(val value: String) {
//    Africa("Africa"),
//    Americas("Americas"),
//    Asia("Asia"),
//    Europe("Europe"),
//    NorthAmerica("North America"),
//    Oceania("Oceania"),
//    SouthAmerica("South America");
//
//    @Serializable
//    companion object {
//        public fun fromValue(value: String): Region = when (value) {
//            "Africa"        -> Africa
//            "Americas"      -> Americas
//            "Asia"          -> Asia
//            "Europe"        -> Europe
//            "North America" -> NorthAmerica
//            "Oceania"       -> Oceania
//            "South America" -> SouthAmerica
//            else            -> throw IllegalArgumentException()
//        }
//    }
//}

@Serializable
data class Currencies (
    @SerializedName("EUR")
    val eur: Aed? = null,

    @SerializedName("ERN")
    val ern: Aed? = null,

    @SerializedName("LRD")
    val lrd: Aed? = null,

    @SerializedName("SOS")
    val sos: Aed? = null,

    @SerializedName("ZMW")
    val zmw: Aed? = null,

    @SerializedName("VES")
    val ves: Aed? = null,

    @SerializedName("TMT")
    val tmt: Aed? = null,

    @SerializedName("ALL")
    val all: Aed? = null,

    @SerializedName("GBP")
    val gbp: Aed? = null,

    @SerializedName("SDG")
    val sdg: BAM? = null,

    @SerializedName("USD")
    val usd: Aed? = null,

    @SerializedName("XAF")
    val xaf: Aed? = null,

    @SerializedName("AZN")
    val azn: Aed? = null,

    @SerializedName("KES")
    val kes: Aed? = null,

    @SerializedName("XOF")
    val xof: Aed? = null,

    @SerializedName("VND")
    val vnd: Aed? = null,

    @SerializedName("AFN")
    val afn: Aed? = null,

    @SerializedName("GTQ")
    val gtq: Aed? = null,

    @SerializedName("KWD")
    val kwd: Aed? = null,

    @SerializedName("STN")
    val stn: Aed? = null,

    @SerializedName("KGS")
    val kgs: Aed? = null,

    @SerializedName("PLN")
    val pln: Aed? = null,

    @SerializedName("GHS")
    val ghs: Aed? = null,

    @SerializedName("AMD")
    val amd: Aed? = null,

    @SerializedName("XCD")
    val xcd: Aed? = null,

    @SerializedName("TJS")
    val tjs: Aed? = null,

    @SerializedName("ETB")
    val etb: Aed? = null,

    @SerializedName("MAD")
    val mad: Aed? = null,

    @SerializedName("NZD")
    val nzd: Aed? = null,

    @SerializedName("BND")
    val bnd: Aed? = null,

    @SerializedName("SGD")
    val sgd: Aed? = null,

    @SerializedName("RON")
    val ron: Aed? = null,

    @SerializedName("BYN")
    val byn: Aed? = null,

    @SerializedName("PAB")
    val pab: Aed? = null,

    @SerializedName("CZK")
    val czk: Aed? = null,

    @SerializedName("PKR")
    val pkr: Aed? = null,

    @SerializedName("PEN")
    val pen: Aed? = null,

    @SerializedName("BBD")
    val bbd: Aed? = null,

    @SerializedName("HUF")
    val huf: Aed? = null,

    @SerializedName("KMF")
    val kmf: Aed? = null,

    @SerializedName("BDT")
    val bdt: Aed? = null,

    @SerializedName("FJD")
    val fjd: Aed? = null,

    @SerializedName("CNY")
    val cny: Aed? = null,

    @SerializedName("COP")
    val cop: Aed? = null,

    @SerializedName("DZD")
    val dzd: Aed? = null,

    @SerializedName("MVR")
    val mvr: Aed? = null,

    @SerializedName("MYR")
    val myr: Aed? = null,

    @SerializedName("PYG")
    val pyg: Aed? = null,

    @SerializedName("UYU")
    val uyu: Aed? = null,

    @SerializedName("ZAR")
    val zar: Aed? = null,

    @SerializedName("VUV")
    val vuv: Aed? = null,

    @SerializedName("SEK")
    val sek: Aed? = null,

    @SerializedName("LBP")
    val lbp: Aed? = null,

    @SerializedName("CLP")
    val clp: Aed? = null,

    @SerializedName("AUD")
    val aud: Aed? = null,

    @SerializedName("BZD")
    val bzd: Aed? = null,

    @SerializedName("GYD")
    val gyd: Aed? = null,

    @SerializedName("MNT")
    val mnt: Aed? = null,

    @SerializedName("TVD")
    val tvd: Aed? = null,

    @SerializedName("DOP")
    val dop: Aed? = null,

    @SerializedName("BOB")
    val bob: Aed? = null,

    @SerializedName("NPR")
    val npr: Aed? = null,

    @SerializedName("BGN")
    val bgn: Aed? = null,

    @SerializedName("MDL")
    val mdl: Aed? = null,

    @SerializedName("BTN")
    val btn: Aed? = null,

    @SerializedName("INR")
    val inr: Aed? = null,

    @SerializedName("KHR")
    val khr: Aed? = null,

    @SerializedName("HTG")
    val htg: Aed? = null,

    @SerializedName("CVE")
    val cve: Aed? = null,

    @SerializedName("GEL")
    val gel: Aed? = null,

    @SerializedName("BIF")
    val bif: Aed? = null,

    @SerializedName("BSD")
    val bsd: Aed? = null,

    @SerializedName("MUR")
    val mur: Aed? = null,

    @SerializedName("LYD")
    val lyd: Aed? = null,

    @SerializedName("MWK")
    val mwk: Aed? = null,

    @SerializedName("MXN")
    val mxn: Aed? = null,

    @SerializedName("SZL")
    val szl: Aed? = null,

    @SerializedName("PGK")
    val pgk: Aed? = null,

    @SerializedName("CHF")
    val chf: Aed? = null,

    @SerializedName("RUB")
    val rub: Aed? = null,

    @SerializedName("ILS")
    val ils: Aed? = null,

    @SerializedName("UGX")
    val ugx: Aed? = null,

    @SerializedName("TOP")
    val top: Aed? = null,

    @SerializedName("AED")
    val aed: Aed? = null,

    @SerializedName("SRD")
    val srd: Aed? = null,

    @SerializedName("UZS")
    val uzs: Aed? = null,

    @SerializedName("SAR")
    val sar: Aed? = null,

    @SerializedName("EGP")
    val egp: Aed? = null,

    @SerializedName("MGA")
    val mga: Aed? = null,

    @SerializedName("CAD")
    val cad: Aed? = null,

    @SerializedName("MRU")
    val mru: Aed? = null,

    @SerializedName("GMD")
    val gmd: Aed? = null,

    @SerializedName("TTD")
    val ttd: Aed? = null,

    @SerializedName("SCR")
    val scr: Aed? = null,

    @SerializedName("JPY")
    val jpy: Aed? = null,

    @SerializedName("BRL")
    val brl: Aed? = null,

    @SerializedName("SYP")
    val syp: Aed? = null,

    @SerializedName("TZS")
    val tzs: Aed? = null,

    @SerializedName("IRR")
    val irr: Aed? = null,

    @SerializedName("KRW")
    val krw: Aed? = null,

    @SerializedName("WST")
    val wst: Aed? = null,

    @SerializedName("JMD")
    val jmd: Aed? = null,

    @SerializedName("NIO")
    val nio: Aed? = null,

    @SerializedName("GNF")
    val gnf: Aed? = null,

    @SerializedName("DKK")
    val dkk: Aed? = null,

    @SerializedName("PHP")
    val php: Aed? = null,

    @SerializedName("NAD")
    val nad: Aed? = null,

    @SerializedName("CRC")
    val crc: Aed? = null,

    @SerializedName("BAM")
    val bam: BAM? = null,

    @SerializedName("MZN")
    val mzn: Aed? = null,

    @SerializedName("KPW")
    val kpw: Aed? = null,

    @SerializedName("UAH")
    val uah: Aed? = null,

    @SerializedName("IQD")
    val iqd: Aed? = null,

    @SerializedName("AOA")
    val aoa: Aed? = null,

    @SerializedName("SLL")
    val sll: Aed? = null,

    @SerializedName("CUC")
    val cuc: Aed? = null,

    @SerializedName("CUP")
    val cup: Aed? = null,

    @SerializedName("RSD")
    val rsd: Aed? = null,

    @SerializedName("TRY")
    val currenciesTRY: Aed? = null,

    @SerializedName("KID")
    val kid: Aed? = null,

    @SerializedName("KZT")
    val kzt: Aed? = null,

    @SerializedName("ISK")
    val isk: Aed? = null,

    @SerializedName("QAR")
    val qar: Aed? = null,

    @SerializedName("JOD")
    val jod: Aed? = null,

    @SerializedName("MMK")
    val mmk: Aed? = null,

    @SerializedName("THB")
    val thb: Aed? = null,

    @SerializedName("NGN")
    val ngn: Aed? = null,

    @SerializedName("BHD")
    val bhd: Aed? = null,

    @SerializedName("LAK")
    val lak: Aed? = null,

    @SerializedName("DJF")
    val djf: Aed? = null,

    @SerializedName("SBD")
    val sbd: Aed? = null,

    @SerializedName("BWP")
    val bwp: Aed? = null,

    @SerializedName("NOK")
    val nok: Aed? = null,

    @SerializedName("ZWL")
    val zwl: Aed? = null,

    @SerializedName("LSL")
    val lsl: Aed? = null,

    @SerializedName("ARS")
    val ars: Aed? = null,

    @SerializedName("YER")
    val yer: Aed? = null,

    @SerializedName("CDF")
    val cdf: Aed? = null,

    @SerializedName("OMR")
    val omr: Aed? = null,

    @SerializedName("IDR")
    val idr: Aed? = null,

    @SerializedName("RWF")
    val rwf: Aed? = null,

    @SerializedName("MKD")
    val mkd: Aed? = null,

    @SerializedName("TND")
    val tnd: Aed? = null,

    @SerializedName("SSP")
    val ssp: Aed? = null,

    @SerializedName("HNL")
    val hnl: Aed? = null,

    @SerializedName("LKR")
    val lkr: Aed? = null
)

@Serializable
data class Aed (
    val name: String,
    val symbol: String
)

@Serializable
data class BAM (
    val name: String
)

@Serializable
data class Demonyms (
    val eng: Eng,
    val fra: Eng
)

@Serializable
data class Eng (
    val f: String,
    val m: String
)

@Serializable
data class Flags (
    val png: String,
    val svg: String,
    val alt: String
)

@Serializable
data class Idd (
    val root: String,
    val suffixes: List<String>
)

@Serializable
data class Maps (
    val googleMaps: String,
    val openStreetMaps: String
)

@Serializable
data class Name (
    val common: String,
    val official: String,
    val nativeName: Map<String, Translation>
)

@Serializable
data class Translation (
    val official: String,
    val common: String
)

@Serializable
data class PostalCode (
    val format: String,
    val regex: String
)

//@Serializable
//enum class StartOfWeek(val value: String) {
//    Monday("monday"),
//    Saturday("saturday"),
//    Sunday("sunday");
//    @Serializable
//    companion object {
//        public fun fromValue(value: String): StartOfWeek = when (value) {
//            "monday" -> Monday
//            "saturday" -> Saturday
//            "sunday" -> Sunday
//            else -> throw IllegalArgumentException()
//        }
//    }
//}