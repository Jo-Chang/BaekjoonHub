#include <iostream>

using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);


void merge_sort(int*, int, int);
void merge(int*, int, int, int);
void check_save_count(int);
void print_arr(int*);

int array_size;
int target_save_count;
int save_cnt = 0;
int result = -1;

int main()
{
    fastio;
    
    int *arr_num;
    int num_size, num_cnt, num, num_ans;
    
    cin >> num_size >> num_cnt;
    array_size = num_size;
    target_save_count = num_cnt;
    
    arr_num = new int[num_size];
    for (int i = 0; i < num_size; i++)
    {
        cin >> arr_num[i];
    }
    
    merge_sort(arr_num, 0, num_size - 1);
    
    cout << result;
    
    return 0;
}

void merge_sort(int *arr, int p, int r)
{
    if (p >= r) return;
    int q = (p + r) / 2;
    
    // cout << "before merge (p="<<p<<", r="<<r<<") :";
    // print_arr(arr);
    merge_sort(arr, p, q);
    merge_sort(arr, q+1, r);
    
    merge(arr, p, q, r);
    // cout << "after merge (p="<<p<<", r="<<r<<") :";
    // print_arr(arr);
}

void merge(int *arr, int p, int q, int r)
{
    int i = p, j = q + 1;
    int *temp = new int[r - p + 1];
    int cnt = 0;
    
    while (i <= q && j <= r)
    {
        if (arr[i] < arr[j])
        {
            temp[cnt++] = arr[i++];
            check_save_count(arr[i-1]);
        }
        else
        {
            temp[cnt++] = arr[j++];
            check_save_count(arr[j-1]);
        }
    }
    
    while (i <= q)
    {
        temp[cnt++] = arr[i++];
        check_save_count(arr[i-1]);
    }
    while (j <= r)
    {
        temp[cnt++] = arr[j++];
        check_save_count(arr[j-1]);
    }
        
    // copy array
    for (int i = p; i <= r; i++)
        arr[i] = temp[i-p];
}

void check_save_count(int num)
{
    save_cnt++;
    if (save_cnt == target_save_count)
    {
        result = num;
    }
}

void print_arr(int *arr)
{
    for (int i = 0; i < array_size; i++)
        cout << arr[i] << " ";
    
    cout << "\n";
}