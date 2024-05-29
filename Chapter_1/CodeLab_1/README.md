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



<details>
<summary>LazyColumn / LazyRow</summary>
<div>

* RecyclerView 와 동일하다고 함.
* `LazyColumn` 은 `RecyclerView` 와 같은 하위 요소를 재활용하지 않음 -> 그럼 왜 동일하다고 한 건지 궁금쓰
  * 단, 컴포저블을 방출하는 것이 Android View 를 인스턴스화 하는 것보다 상대적으로 비용이 적게 듬 -> 성능 유지

```kotlin
@Composable
fun Greetings(modifier: Modifier = Modifier, names: List<String> = List(1000) { "$it" }) {
   LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
      items(items = names) { name ->
         Greeting(name = name)
      }
   }
}
```
</div>
</details>

<br/>



<details>
<summary>애니메이션 동적 변화</summary>
<div>

* 동적 변화 시 padding 을 주게 되는 경우 0.dp 일 때 - 값을 가지게 됨
* `coereceAtLeast` 를 통해 최소 값을 주는 것을 필요로 함

```kotlin
var expanded by rememberSaveable { mutableStateOf(false) }
val extraPadding by animateDpAsState(
   if (expanded) 48.dp else 0.dp,
   animationSpec = spring(
      dampingRatio = Spring.DampingRatioMediumBouncy,
      stiffness = Spring.StiffnessLow
   ),
   label = ""
)

Surface(
   color = MaterialTheme.colorScheme.primary,
   modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
) {
   Column(
      modifier = Modifier
         .fillMaxWidth()
         .padding(24.dp)
   ) {
      Row(
         verticalAlignment = Alignment.CenterVertically
      ) {
         Column(
            modifier = Modifier
               .weight(1f)
               .padding(bottom = extraPadding.coerceAtLeast(0.dp))
         ) {
            Text(text = "Hello ")
            Text(text = name)
         }
         ElevatedButton(onClick = { expanded = !expanded }) {
            Text(text = if (expanded) "Show less" else "Show more")
         }
      }
      if (expanded) {
         Text(text = "more text", modifier = Modifier.padding(vertical = 20.dp))
      }
   }

}
```
</div>
</details>

<br/>

