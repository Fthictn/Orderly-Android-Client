package Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VeriListem {

    @SerializedName("page")
    @Expose
    var page : Int? = null

    @SerializedName("per_page")
    @Expose
    var perPage : Int? = null

    @SerializedName("total")
    @Expose
    var total : Int? = null

    @SerializedName("total_pages")
    @Expose
    var totalPage : Int? = null

    @SerializedName("data")
    @Expose
    var data : List<Datum>? = null

    constructor(page: Int?, perPage: Int?, total: Int?, totalPage: Int?, data: List<Datum>?) {
        this.page = page
        this.perPage = perPage
        this.total = total
        this.totalPage = totalPage
        this.data = data
    }

    fun getEmployee(): List<Datum>? {
        return data
    }

    init {
        page = null
        perPage = null
        total = null
        totalPage = null
        data = null
    }
}