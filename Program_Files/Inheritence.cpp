/* Online C++ Compiler and Editor */
#include <iostream>

class A
{
public:
    // Print out class A stuff
    virtual void foo()
    {
        std::cout << "A::foo()" << std::endl;
    }
};

// Class B which extends A
class B : public A
{
public:
    // Print out class B stuff
    void foo() override
    {
        std::cout << "B::foo()" << std::endl;
    }
};

// Class C which extends class B
class C : public B
{
public:
    // Print out class C stuff
    void foo() override
    {
        std::cout << "C::foo()" << std::endl;
    }
};

class Test
{
public:
    void run()
    {
        // Create A obj
        A* a = new A();
        // statically bound to A's method
        a->foo();
        // Cleanup as we reuse a
        delete a;

        // Create B obj using a var (because OOP we can do this yay)
        a = new B();
        // dynamically bound to B's method
        a->foo();
        // Cleanup as we reuse a
        delete a;

        // Create B obj using a var (because OOP we can do this yay)
        a = new C();
        // dynamically bound to C's method
        a->foo();
        // Cleanup as we reuse a
        delete a;
    }
};

int main()
{
    // Create test class, which will run our test
    Test test;
    // Run the test, duh
    test.run();
    return 0;
}