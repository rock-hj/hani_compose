1. **Compose 레이아웃과 수정자의 기본 개념**:
    - 레이아웃은 UI 요소의 배열과 정렬을 담당합니다.
    - 수정자는 컴포저블의 크기, 레이아웃, 동작, 외관 등을 변경할 수 있습니다.

2. **게임 구성 요소 정렬**:
    - `fillMaxSize` 수정자를 사용하여 레이아웃을 전체 크기로 확장합니다.
    - 배치의 차이점을 설명합니다: 주축에서의 배열과 교차 축에서의 정렬.

3. **개별 정렬 수정**:
    - `Align` 수정자를 사용하여 특정 컴포저블을 독립적으로 정렬할 수 있습니다.

4. **Material Components 사용**:
    - 머티리얼 컴포넌트인 `Scaffold` 레이아웃을 사용하여 화면의 상단과 하단에 헤더와 버튼을 추가합니다.
    - `Button`, `Card`, `Switch` 등의 다양한 머티리얼 컴포넌트를 소개합니다.

5. **Lazy 컴포넌트 사용**:
    - Lazy 컴포넌트를 사용하여 스크롤 시점에만 요소를 로드하여 성능을 최적화합니다.
    - Lazy Vertical Grid를 사용하여 그리드 레이아웃을 구성합니다.

### 중요한 점:
1. **레이아웃과 수정자**는 Compose UI의 핵심 요소로, UI 요소의 배열과 동작을 설정할 수 있습니다.
2. **행(Row)과 열(Column) 레이아웃**을 사용하여 요소를 수평 및 수직으로 정렬할 수 있습니다.
3. **`fillMaxSize` 수정자**를 사용하여 레이아웃을 전체 화면 크기로 확장할 수 있습니다.
4. **Material Components**를 사용하여 버튼, 카드, 스위치 등 다양한 인터랙티브 UI 요소를 추가할 수 있습니다.
5. **Lazy 컴포넌트**를 사용하여 대량의 데이터나 이미지가 있을 때 스크롤 시점에만 로드하여 성능을 최적화할 수 있습니다.


#### [1. Jetpack Compose: Layout Basics](https://youtu.be/xc8nAcVvpxY)
- **Column**: 수직으로 구성되는 요소 집합.
- **Row**: 수평으로 구성되는 요소 집합.
- **Box**: 겹쳐 놓을 수 있는 컨테이너.
- **Modifier**: 컴포저블의 크기, 레이아웃, 동작 등을 수정하는 객체.
- **Padding**: 컴포넌트 주위에 여백을 추가.
- **Alignment**: 요소 정렬 방식.

#### [2. Jetpack Compose: State and State Hoisting](https://youtu.be/1ANt65eoNhQ)
- **State**: 컴포저블의 상태를 저장.
- **MutableState**: 변경 가능한 상태.
- **remember**: 상태를 재구성 동안 유지.
- **state hoisting**: 상태를 부모로 이동하여 공유.
- **ViewModel**: 화면 수명 주기와 관련된 상태 관리.

#### [3. Jetpack Compose: Theming and Styling](https://youtu.be/xS4GpdIQUEo)
- **MaterialTheme**: 앱의 스타일과 테마를 정의.
- **Color**: 색상 정의.
- **Typography**: 글꼴과 텍스트 스타일 정의.
- **Shapes**: 모양과 테두리 스타일 정의.
- **Dark theme**: 어두운 테마 설정.

#### [4. Jetpack Compose: Lists and Grids](https://youtu.be/_qls2CEAbxI)
- **LazyColumn**: 효율적인 스크롤 가능한 열.
- **LazyRow**: 효율적인 스크롤 가능한 행.
- **LazyGrid**: 그리드 레이아웃.
- **Item**: 리스트나 그리드의 개별 항목.
- **key**: 항목의 고유 키.
- **contentPadding**: 내용의 여백.

#### [5. Jetpack Compose: Animation Basics](https://youtu.be/0mfCbXrYBPE)
- **animate**: 값의 애니메이션.
- **transition**: 상태 간 애니메이션.
- **updateTransition**: 상태 기반 애니메이션 업데이트.
- **AnimatedVisibility**: 요소의 가시성 애니메이션.

#### [6. Jetpack Compose: Navigation](https://youtu.be/1yiuxWK74vI)
- **NavHost**: 네비게이션 호스트 설정.
- **NavController**: 네비게이션 컨트롤러.
- **composable**: 네비게이션 대상.
- **navigation graph**: 네비게이션 경로 정의.

#### [7. Jetpack Compose: Performance Optimization](https://youtu.be/l6rAoph5UgI)
- **Recomposition**: 컴포저블 재구성.
- **remember**: 상태를 재구성 동안 유지.
- **derivedStateOf**: 상태에서 파생된 상태.
- **snapshotFlow**: 상태 변화 추적.

#### [8. Jetpack Compose: Testing](https://youtu.be/OeC5jMV342A)
- **ComposeTestRule**: Compose 테스트 규칙.
- **createComposeRule**: Compose 테스트 규칙 생성.
- **onNodeWithText**: 텍스트로 노드 찾기.
- **performClick**: 클릭 동작 수행.
- **assertIsDisplayed**: 요소가 화면에 표시되는지 확인.

## 코드랩 설명

### [Jetpack Compose Theming](https://developer.android.com/codelabs/jetpack-compose-theming?hl=ko)
- **핵심 내용**: 테마 및 스타일링 기법을 이해하고 적용.
- **예시 코드**:

```kotlin
@Composable
fun MyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Purple200,
            primaryVariant = Purple700,
            secondary = Teal200
        )
    } else {
        lightColors(
            primary = Purple500,
            primaryVariant = Purple700,
            secondary = Teal200
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
```

# Jetpack Compose Theming 코드랩

## 핵심 내용
Jetpack Compose를 사용하여 테마와 스타일을 설정하는 방법을 학습합니다. 다크 모드 지원, 색상, 타이포그래피, 모양을 커스터마이징하는 방법을 이해하고 적용할 수 있습니다.

### 테마 설정 예시

```kotlin
@Composable
fun MyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Purple200,
            primaryVariant = Purple700,
            secondary = Teal200
        )
    } else {
        lightColors(
            primary = Purple500,
            primaryVariant = Purple700,
            secondary = Teal200
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
```

### 키워드 설명
* MaterialTheme: 앱의 전체 스타일을 정의.
* Colors: 앱에서 사용할 색상 팔레트를 설정.
* Typography: 앱의 텍스트 스타일을 설정.
* Shapes: 모양과 테두리 스타일을 설정.
* darkTheme: 시스템 다크 테마 여부를 확인.

### Jetpack Compose Animation 코드랩


* 애니메이션 적용 예시
```kotlin
@Composable
fun AnimatedVisibilitySample() {
    var visible by remember { mutableStateOf(true) }
    Column {
        Button(onClick = { visible = !visible }) {
            Text("Toggle")
        }
        AnimatedVisibility(visible = visible) {
            Box(
                Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )
        }
    }
}
```

### 키워드 설명
- **AnimatedVisibility**: 요소의 가시성에 애니메이션을 적용합니다.
  ```kotlin
  AnimatedVisibility(visible = visible) {
      Box(
          Modifier
              .size(100.dp)
              .background(Color.Red)
      )
  }
   ```
  
- **transition** : 상태 간의 애니메이션을 정의합니다.
```kotlin
val transition = updateTransition(targetState = state, label = "transition")
```
- **animate**: 값의 애니메이션을 처리합니다.
```kotlin
val animatedValue by animateDpAsState(targetValue = if (isSelected) 100.dp else 50.dp)
```
- **remember**: 상태를 재구성 동안 유지합니다.
```kotlin
val counter = remember { mutableStateOf(0) }
```
- **mutableStateOf**: 변경 가능한 상태를 생성합니다.
```kotlin
var visible by remember { mutableStateOf(true) }
```