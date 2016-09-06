# Android N for Developers

## Feature
  * Multi-window support
  * Data Saver
  * Vulkan API
  * Number Blocking

## Upgrade
  * Notification Enhancement
  * Quick Settings Tile API

## Multi-window support
둘 이상의 앱을 동시에 표현하기 위한 신규 멀티태스킹 기능
  * 화면 분할 모드에서 두 개의 앱을 좌우 또는 상하로 실행 가능
  * 앱 사이의 분할선을 끌어서 앱의 크기를 조정 가능
![Apps running in split-screen mode](https://developer.android.com/images/android-7.0/mw-splitscreen.png)


## Notification Enhancements
  * Template updates
    * 알림 관련 템플릿 신규 추가
  * Messaging style customization
    * 신규 추가된 MessageStyle 클래스를 사용하여 message, title, contents view 구성 가능
    * https://developer.android.com/guide/topics/ui/notifiers/notifications.html#style
  * Bundled notifications
    * 시스템에서 메시지를 주제별로 그룹화 표시 및 일괄 처리 가능
  * Direct reply
    * 알림 인터페이스 내에서 인라인 회신 지원
  * Custom views
    * 신규 추가된 API를 활용하여 알림 헤더 및 액션과 같은 시스템 장식 사용 가능
    * https://developer.android.com/guide/topics/ui/notifiers/notifications.html#custom

![](https://developer.android.com/images/android-7.0/notifications-1.png)
![](https://developer.android.com/images/android-7.0/notifications-2.png)
![Bundled notifications and direct reply](https://developer.android.com/images/android-7.0/notifications-3.png)


## Data Saver
  * 사용자가 Settings에서 Data Saver를 활성화하면 앱에 의해 사용되는 모바일 데이터 사용량 및 사용하는 방식을 제어할 수 있음.
![Data Saver in Settings](https://developer.android.com/images/android-7.0/datasaver.png)


## Vulkan API
  * Vulkan(3D 그래픽 및 렌더링을 위한 공개 표준)를 통합한 새로운 3D 렌더링 API
  * CPU 오버 헤드를 최소화하도록 설계되었으며, 병렬 처리 성능을 높임
  * GPU 작업을 직접적으로 제어할 수 있는 API 제공
  * Vulkan 지원 하드웨어가 있는 기기에서만 사용 가능


## Quick Settings Tile API
  * 드래그앤드랍으로 타일을 추가하거나 이동
  * 앱 개발자가 자신만의 Quick Settings 타일 정의
![Quick Settings tiles in the notification shade](https://developer.android.com/images/android-7.0/quicksettings.png)


## Number Blocking
  * 플랫폼에서 번호 차단을 지원
  * 통화에서 차단된 번호가 텍스트에서도 차단
  * 차단된 번호는 재설정 시에도 백업 및 복원 기능을 통해 기기에서 유지 가능
  * 여러 앱이 동일한 차단된 번호 목록 사용할 수 있음


## Call Screening
  * 기본 전화 앱이 원치 않는 통화를 차단하는 기능 제공
  * 수신 통화 거절
  * 통화 기록에서 제외
  * 통화 알림을 사용자에게 표시하지 않음


## Multi-locale Support, More Languages
  * 검색 결과를 여러 언어로 표시하거나 사용자가 이미 알고 있는 언어로는 웹페이지를 번역하지 않는 등의 환경을 다중 로케일 사용자들에게 제공
  * 100 가지 이상의 새로운 언어 추가 지원


## New Emojis
  * skin tone emojis와 관련 기능을 추가 제공
  * http://unicode.org/emoji/charts/full-emoji-list.html


## ICU4J APIs
  * icu4j.jar ? unicode and globalization support library for java
  * ICU4J API의 일부 기능을 android.icu API에서 제공
