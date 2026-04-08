package fr.epf.sin2.gc

import fr.epf.sin2.gc.model.Client
import fr.epf.sin2.gc.model.Gender


fun Client.getName() : String {
    return "${this.firstName} ${this.lastName}"
}

val Client.fullName
    get()  = "${this.firstName} ${this.lastName}"

val Client.image
    get() = when(gender) {
        Gender.MAN -> R.drawable.man
        Gender.WOMAN -> R.drawable.woman
    }

