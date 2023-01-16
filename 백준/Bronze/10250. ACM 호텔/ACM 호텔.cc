#include <iostream>

using namespace std;

int main()
{
    int test_case;
    int height, width, order;
    int room_num;
    
    cin >> test_case;
    for (int i = 1; i <= test_case; i++)
    {
        cin >> height >> width >> order;
        // if (order > height * width)
        //     cout << "Rooms are full";
        
        order--;    // 계산의 편의성을 위해
        room_num = ((order % height + 1) * 100) + (order / height + 1);
        cout << room_num << endl;
    }
    
    return 0;
}