cmake_minimum_required(VERSION 3.8)
project(AlgorithmsCPP)

set(CMAKE_CXX_STANDARD 11)

# lib:simple_list (written in .c)
add_subdirectory(library/list)

# 遍历当前目录下的所有文件
file(GLOB use_cases RELATIVE ${CMAKE_SOURCE_DIR}/usecase usecase/*)

foreach (item ${use_cases})
    if (IS_DIRECTORY ${CMAKE_SOURCE_DIR}/usecase/${item})
        # 如果是文件夹，添加子目录
        add_subdirectory(usecase/${item})
    else ()
        # 如果是文件，添加可执行文件
        get_filename_component(filename ${item} NAME_WE)
        add_executable(${filename} usecase/${item})
        target_link_libraries(${filename} PRIVATE simple_list)
        target_include_directories(${filename} PRIVATE library/list ./include)
    endif ()
endforeach ()
