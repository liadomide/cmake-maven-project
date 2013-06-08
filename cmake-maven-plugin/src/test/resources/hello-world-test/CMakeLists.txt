cmake_minimum_required(VERSION 2.6.4)
project(HelloWorld)
add_executable(hello main.c)

enable_testing()
include(CTest)
add_subdirectory(tests)