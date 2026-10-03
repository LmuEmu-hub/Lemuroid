cmake_minimum_required(VERSION 3.18.1)

project("emulator-native")

add_library(
    emulator-native
    SHARED
    src/main/cpp/libretro_cheat_jni.cpp
)

find_library(
    log-lib
    log
)

target_link_libraries(
    emulator-native
    ${log-lib}
)
