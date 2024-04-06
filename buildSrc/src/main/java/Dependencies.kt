
object Version{

    const val coreKtx = "1.12.0"
    const val appCompat = "1.6.1"
    const val material = "1.11.0"
    const val constraintlayout = "2.1.4"
    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espressoCore = "3.5.1"

    const val retrofit = "2.7.2"
    const val converterGson = "2.7.2"
    const val okhttp = "3.6.0"
    const val loggingIntercepter = "4.11.0"

    const val roomRunTime = "2.5.2"
    const val roomKtx = "2.5.2"
    const val roomCompiler = "2.5.2"
    const val kaptRoomCompiler = "2.5.2"

    const val hiltAndroid = "2.48"
    const val hiltCompiler = "2.48"

    const val coroutineCore = "1.4.1"
    const val coroutineAndroid = "1.4.1"

    const val viewModelKtx = "2.3.1"
    const val circularImage = "3.1.0"

    const val activityKtx = "1.3.1"

    const val circleimageview = "3.1.0"
    const val glide = "4.16.0"

    const val paging3 = "3.2.1"

    const val mockitoCore = "3.12.4"
    const val archcoreTest = "1.0.0"
    const val roomTesting = "1.0.0"
    const val coreTest = "1.4.0"
}

object Deps{

    // Default Core

    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Version.constraintlayout}"
    const val junit = "junit:junit:${Version.junit}"
    const val extJunit = "androidx.test.ext:junit:${Version.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.converterGson}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
    const val loggingIntercepter = "com.squareup.okhttp3:logging-interceptor:${Version.loggingIntercepter}"

    // Room
    const val roomRunTime = "androidx.room:room-runtime:${Version.roomRunTime}"
    const val roomKtx = "androidx.room:room-ktx:${Version.roomKtx}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.roomCompiler}"
    const val kaptRoomCompiler = "androidx.room:room-compiler:${Version.kaptRoomCompiler}"

    // Hilt Dagger
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hiltAndroid}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hiltCompiler}"

    // Coroutine
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutineCore}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutineAndroid}"

    // ViewModel
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.viewModelKtx}"
    const val activityKtx = "androidx.activity:activity-ktx:${Version.activityKtx}"

    // Circular Image & Image Loading Glide
    const val circleimageview = "de.hdodenhof:circleimageview:${Version.circleimageview}"
    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"

    const val paging3 = "androidx.paging:paging-runtime:${Version.paging3}"

    const val mockitoCore = "org.mockito:mockito-core:${Version.mockitoCore}"

    const val archcoreTest = "android.arch.core:core-testing:${Version.archcoreTest}"
    const val roomTesting = "androidx.room:room-testing:${Version.roomTesting}"
    const val coreTest = "androidx.test:core::${Version.coreTest}"




}