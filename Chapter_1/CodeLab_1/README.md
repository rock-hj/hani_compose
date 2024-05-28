# Compose Codelab 1

* `Jetpack Compose` 는 네이티브 Android UI 를 빌드하기 위한 최신 툴킷.
* UI 개발을 단순화 하고 가속화 함

<details>
<summary>주요 개념</summary>
<div>

1. `Compose` 함수
   * Composable 함수는 Compose의 빌딩 블록
   * `@Composable` 어노테이션이 붙어 있음

2. UI 구성 요소
   * `Text`, `Button`, `Image`와 같은 구성 요소를 사용하여 UI를 빌드
   * 구성 요소는 중첩되고 함께 조합 가능

3. Compose에서의 상태
   * 상태 관리는 `@State`와 `@MutableState` 어노테이션을 사용
   * 상태가 변경될 때 Compose는 자동으로 UI를 업데이트

</div>
</details>


<br/>


<details>
<summary>상태 관리</summary>
<div>

* Compose 에서 상태는 `remember` & `mutableStateOf` 를 사용
* 바로 초기화해서 사용하지 않는 이유는 mutableStateOf 로 value 를 반복 사용하지 않게 하기 위함
```kotlin
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text("Clicked $count times")
    }
}
```

</div>
</details>


<br/>


<details>
<summary>상태 호이스팅</summary>
<div>

* 상태 호이스팅은 상태를 상위 컴포저블로 이동시켜 상태를 공유하는 패턴
* 상위 컴포저블에서 상태를 관리하고 하위 컴포저블에 상태와 상태 변경 함수를 전달

```kotlin
@Composable
fun Parent() {
   var count by remember { mutableStateOf(0) }

   Child(count) { count++ }
}

@Composable
fun Child(count: Int, onClick: () -> Unit) {
   Button(onClick = onClick) {
      Text("Clicked $count times")
   }
}
```
</div>
</details>

<br/>