#include <jni.h>
#include <string>

// 宣告 Libretro 核心提供的 C 語言 API
extern "C" {
    void retro_cheat_reset(void);
    void retro_cheat_set(unsigned index, bool enabled, const char *code);
}

extern "C" JNIEXPORT void JNICALL
Java_com_swordfish_lemuroid_lib_emulator_LibretroBridge_nativeCheatReset(
        JNIEnv* env,
        jobject /* this */) {
    retro_cheat_reset();
}

extern "C" JNIEXPORT void JNICALL
Java_com_swordfish_lemuroid_lib_emulator_LibretroBridge_nativeCheatSet(
        JNIEnv* env,
        jobject /* this */,
        jint index,
        jboolean enabled,
        jstring code) {
    if (code == NULL) return;
    
    const char *nativeCode = env->GetStringUTFChars(code, 0);
    
    retro_cheat_set(static_cast<unsigned>(index), enabled == JNI_TRUE, nativeCode);
    
    env->ReleaseStringUTFChars(code, nativeCode);
}
