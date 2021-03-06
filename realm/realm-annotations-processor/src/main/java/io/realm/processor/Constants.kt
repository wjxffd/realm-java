/*
 * Copyright 2019 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.processor

object Constants {

    const val REALM_PACKAGE_NAME = "io.realm"
    const val PROXY_SUFFIX = "RealmProxy"
    const val INTERFACE_SUFFIX = "RealmProxyInterface"
    const val INDENT = "    "
    const val DEFAULT_MODULE_CLASS_NAME = "DefaultRealmModule"
    const val STATEMENT_EXCEPTION_ILLEGAL_NULL_VALUE =
            "throw new IllegalArgumentException(\"Trying to set non-nullable field '%s' to null.\")"
    const val STATEMENT_EXCEPTION_NO_PRIMARY_KEY_IN_JSON =
            "throw new IllegalArgumentException(\"JSON object doesn't have the primary key field '%s'.\")"
    const val STATEMENT_EXCEPTION_PRIMARY_KEY_CANNOT_BE_CHANGED =
            "throw new io.realm.exceptions.RealmException(\"Primary key field '%s' cannot be changed after object was created.\")"
    const val STATEMENT_EXCEPTION_ILLEGAL_JSON_LOAD
            = "throw new io.realm.exceptions.RealmException(\"\\\"%s\\\" field \\\"%s\\\" cannot be loaded from json\")"
    val JAVA_TO_REALM_TYPES = hashMapOf<String, RealmFieldType>()
    val LIST_ELEMENT_TYPE_TO_REALM_TYPES = hashMapOf<String, RealmFieldType>()

    /**
     * Realm types and their corresponding Java types.
     *
     * @param realmType The simple name of the Enum type used in the Java bindings, to represent this type.
     * @param javaType The simple name of the Java type needed to store this Realm Type
     */
    enum class RealmFieldType(realmType: String?, val javaType: String?) {
        NOTYPE(null, "Void"),
        INTEGER("INTEGER", "Long"),
        FLOAT("FLOAT", "Float"),
        DOUBLE("DOUBLE", "Double"),
        BOOLEAN("BOOLEAN", "Boolean"),
        STRING("STRING", "String"),
        DATE("DATE", "Date"),
        BINARY("BINARY", "BinaryByteArray"),
        REALM_INTEGER("INTEGER", "Long"),
        OBJECT("OBJECT", "Object"),
        LIST("LIST", "List"),

        BACKLINK("LINKING_OBJECTS", null),

        INTEGER_LIST("INTEGER_LIST", "List"),
        BOOLEAN_LIST("BOOLEAN_LIST", "List"),
        STRING_LIST("STRING_LIST", "List"),
        BINARY_LIST("BINARY_LIST", "List"),
        DATE_LIST("DATE_LIST", "List"),
        FLOAT_LIST("FLOAT_LIST", "List"),
        DOUBLE_LIST("DOUBLE_LIST", "List");

        /**
         * The name of the enum, used in the Java bindings, used to represent the corresponding type.
         */
        val realmType: String = "RealmFieldType.$realmType"
    }

    init {
        JAVA_TO_REALM_TYPES["byte"] = RealmFieldType.INTEGER
        JAVA_TO_REALM_TYPES["short"] = RealmFieldType.INTEGER
        JAVA_TO_REALM_TYPES["int"] = RealmFieldType.INTEGER
        JAVA_TO_REALM_TYPES["long"] = RealmFieldType.INTEGER
        JAVA_TO_REALM_TYPES["float"] = RealmFieldType.FLOAT
        JAVA_TO_REALM_TYPES["double"] = RealmFieldType.DOUBLE
        JAVA_TO_REALM_TYPES["boolean"] = RealmFieldType.BOOLEAN
        JAVA_TO_REALM_TYPES["java.lang.Byte"] = RealmFieldType.INTEGER
        JAVA_TO_REALM_TYPES["java.lang.Short"] = RealmFieldType.INTEGER
        JAVA_TO_REALM_TYPES["java.lang.Integer"] = RealmFieldType.INTEGER
        JAVA_TO_REALM_TYPES["java.lang.Long"] = RealmFieldType.INTEGER
        JAVA_TO_REALM_TYPES["java.lang.Float"] = RealmFieldType.FLOAT
        JAVA_TO_REALM_TYPES["java.lang.Double"] = RealmFieldType.DOUBLE
        JAVA_TO_REALM_TYPES["java.lang.Boolean"] = RealmFieldType.BOOLEAN
        JAVA_TO_REALM_TYPES["java.lang.String"] = RealmFieldType.STRING
        JAVA_TO_REALM_TYPES["java.util.Date"] = RealmFieldType.DATE
        JAVA_TO_REALM_TYPES["byte[]"] = RealmFieldType.BINARY
        // TODO: add support for char and Char

        LIST_ELEMENT_TYPE_TO_REALM_TYPES["java.lang.Byte"] = RealmFieldType.INTEGER_LIST
        LIST_ELEMENT_TYPE_TO_REALM_TYPES["java.lang.Short"] = RealmFieldType.INTEGER_LIST
        LIST_ELEMENT_TYPE_TO_REALM_TYPES["java.lang.Integer"] = RealmFieldType.INTEGER_LIST
        LIST_ELEMENT_TYPE_TO_REALM_TYPES["java.lang.Long"] = RealmFieldType.INTEGER_LIST
        LIST_ELEMENT_TYPE_TO_REALM_TYPES["java.lang.Float"] = RealmFieldType.FLOAT_LIST
        LIST_ELEMENT_TYPE_TO_REALM_TYPES["java.lang.Double"] = RealmFieldType.DOUBLE_LIST
        LIST_ELEMENT_TYPE_TO_REALM_TYPES["java.lang.Boolean"] = RealmFieldType.BOOLEAN_LIST
        LIST_ELEMENT_TYPE_TO_REALM_TYPES["java.lang.String"] = RealmFieldType.STRING_LIST
        LIST_ELEMENT_TYPE_TO_REALM_TYPES["java.util.Date"] = RealmFieldType.DATE_LIST
        LIST_ELEMENT_TYPE_TO_REALM_TYPES["byte[]"] = RealmFieldType.BINARY_LIST
    }
}
