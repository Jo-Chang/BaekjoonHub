#include <iostream>
#include <algorithm>
using namespace std;
bool compare(pair<int, int> a, pair<int,int> b){
  if(a.second == b.second){
    return a.first < b.first;
  }
  else{
    return a.second < b.second;
  }
}

int main() {
  cin.tie(NULL);
  ios_base::sync_with_stdio(false);
  int N,x,y;
  cin >> N;
  pair<int, int> *point = new pair<int, int>[N];
  for(int i=0; i<N; i++){
    cin >> x >> y;
    point[i].first = x;
    point[i].second = y;
  }
  sort(point, point+N, compare);
  for(int i=0; i<N; i++){
    cout << point[i].first << " " << point[i].second << '\n';
  }
}