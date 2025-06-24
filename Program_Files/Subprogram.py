# Online Python-3 Compiler (Interpreter)
def outer_func():
    outer_var = "outer"

    def middle_func():
        middle_var = "middle"

        def inner_func():
            inner_var = "inner"
            print("Inner function")
            print(f"Inner function variable: {inner_var}")
            print(f"Middle function variable: {middle_var}")
            print(f"Outer function variable: {outer_var}")
        
        inner_func()
        print("Middle funciton")
        print(f"Middle function variable: {middle_var}")
        print(f"Outer function variable: {outer_var}")
    
    middle_func()
    print("Outer function")
    print(f"Outer function variable: {outer_var}")

outer_func()