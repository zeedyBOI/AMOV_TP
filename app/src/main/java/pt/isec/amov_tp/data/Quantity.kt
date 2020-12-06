package pt.isec.amov_tp.data

import java.io.Serializable

data class Quantity(var amount: Double, var unit: String = "Unit(s)") : Serializable{

}