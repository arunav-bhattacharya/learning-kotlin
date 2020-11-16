package com.arunav.kotlin.classes

enum class PriorityEnum(val value: Int) {
    MINOR(-1) {
        // Overrides the default toString method of PriorityEnum
        override fun toString(): String {
            return "Minor Priority"
        }

        override fun floatMapping(): Float {
            return -1.0f;
        }
    },
    MAJOR(5){
        override fun floatMapping(): Float {
            return 5f;
        }
    },
    NORMAL(1) {
        override fun floatMapping(): Float {
            return 1.0f;
        }
    },
    CRITICAL(10) {
        override fun floatMapping(): Float {
            return 10.0f;
        }
    };

    abstract fun floatMapping(): Float
}

fun main() {

    val priority = PriorityEnum.NORMAL

    println(priority)
    println(priority.value) // Prints the value
    println("Ordinal=" + PriorityEnum.CRITICAL.ordinal) // Prints the ordinal position of the enum
    println(PriorityEnum.MAJOR.name) // Prints the name of the ordinal
    println(PriorityEnum.MAJOR.floatMapping()) // Prints the float value that is mapped

    // Iterate over enum values
    for (p in PriorityEnum.values()) {
        println(p)
    }

    // Get enum from name/value using valueOf() method
    val p = PriorityEnum.valueOf("MINOR")
    println(p.value == PriorityEnum.MINOR.value)


}