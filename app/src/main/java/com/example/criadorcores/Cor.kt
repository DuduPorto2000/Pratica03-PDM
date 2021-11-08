import android.graphics.Color

class RGB() {
    private var Vermelho: Int = 0
    private var Verde: Int = 0
    private var Azul: Int = 0

    fun setRed(value: Int) {
        Vermelho = value
    }

    fun setGreen(value: Int) {
        Verde = value
    }

    fun setBlue(value: Int) {
        Azul = value
    }

    fun toInt(): Int {
        return Color.rgb(Vermelho, Verde, Azul)
    }

    fun toIntReverse(): Int {
        return Color.rgb(255 - Vermelho, 255 - Verde, 255 - Azul)
    }

    override fun toString(): String {
        return toInt().toString()
    }

    fun toHex(): String {
        return "#" + Integer.toHexString( toInt() ).uppercase().substring(2,8)
    }
}