# PPPwn-Android-App

## this project is for make app via Android studio Follow this steps:

1-open new project on android studio then copy the file as the same place of the same file names 

2-add this to file build.gradle (Module: app):

 ```sh

dependencies {
    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.0'
    implementation 'androidx.core:core-ktx:1.3.2'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'com.google.code.gson:gson:2.10.1'
    implementation 'com.squareup.okhttp3:okhttp:4.9.3'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.9.3'
    implementation 'androidx.recyclerview:recyclerview:1.2.1'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    implementation 'com.google.android.gms:play-services-location:19.0.0'
    implementation 'com.google.firebase:firebase-bom:29.1.0'
    implementation 'com.google.firebase:firebase-analytics:19.0.0'
    implementation 'com.google.firebase:firebase-messaging:21.0.0'
    implementation 'com.google.firebase:firebase-firestore:24.0.2'
    implementation 'com.google.firebase:firebase-auth:21.0.0'
    implementation 'androidx.activity:activity-runtime:1.4.0'
    implementation 'androidx.fragment:fragment-ktx:1.4.0'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.4'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation 'androidx.test.rules:rules:1.4.0'
    androidTestImplementation 'androidx.test.runner:runner:1.4.0'
    androidTestImplementation 'androidx.test.espresso:espresso-contrib:3.5.1'
    androidTestImplementation 'androidx.test.espresso:espresso-intents:3.5.1'
    androidTestImplementation 'androidx.test.junit:junit-rules:1.1.4'
    androidTestImplementation 'androidx.test.ext:junit:1.1.4'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation 'androidx.test.espresso:espresso-contrib:3.5.1'
    androidTestImplementation 'androidx.test.espresso:espresso-intents:3.5.1'
    debugImplementation 'com.squareup.leakcanary:leakcanary-android:2.0-beta-5'
    releaseImplementation 'com.squareup.leakcanary:leakcanary-android:2.0-beta-5'
}

```

3-add this to file values/strings.xml:

```sh

<resources>
    <string-array name="firmware_options">
        <item>900</item>
        <item>903</item>
        <item>960</item>
        <item>1000</item>
        <item>1001</item>
        <item>1071</item>
        <item>1100</item>
    </string-array>
</resources>

```

## this project need library subprocess installed on project

## Note: any interface option selected is not work at now , I make it to default [--interface=Ethernet] so you need to modify it.

## Note2: any option of Firmware work but if you add the right stage1 and stage2 bin on files so it need modify the code to make it find which Firmware with which stage1 and stage2. 


# Thanks to all developers on the sence 
