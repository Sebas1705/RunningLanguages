#include <iostream>

namespace one{
    int x=1;
}

namespace two{
    int x=2;
}

int main()
{
    using namespace two;
    
    using std::cout;
    
    cout << x << std::endl;
    cout << one::x << std::endl;
    return 0;
}
