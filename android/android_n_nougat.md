# Android N for Developers

Android N 플랫폼의 주요 변경사항은 배터리 & 메모리 최적화, 모바일데이터 사용량 최적화, 보안 입니다.

배터리 및 모바일 데이터, 메모리 사용 최적화를 위해 Data saver, Doze mode, Background optimization 과 같은 기능이 추가되었습니다. 이 기능들이 활성화 되면 앱에서 Backgound 서비스를 임의 실행시키거나 모바일 데이터를 사용하는 Network 연결 등 관련 작업은 제한됩니다. 효율적인 백그라운드 작업을 위해 JobScheduler와 GCMNetworkManager을 사용하도록 권장하고 있습니다.

시작화면을 암호화 하거나 폴더별 잠금하여 사용할 수 있도록 개인 정보 보호 기능이 강화되었습니다. 또한, 개발측면에서 앱의 성능 개선을 위해 성능 모니터링 및 상태 관련 힌트 API를 제공하고 있습니다.

### 사용자 측면 주요 기능
  * Multi-window support
  * Notification Enhancement
    * template update, messaging style cutomization, bundled notifications, direct reply
  * data saver
  * battery optimization
  * VR & Daydream support
  * 3D 렌더링 Vulkan API support
  * 시작화면 암호화, 폴더 잠금 등의 개인 정보 보호 기능 강화

### 개발자 측면 주요 기능
  * 프로파일 가이드 JIT/AOT 컴파일
    * 앱의 업데이트, 설치, 초기 실행시간, 안드로이드 업데이트 때 앱을 갱신하는 시간 개선
  * doze mode
  * Background optimization(메모리와 배터리 최적화)
  * 배터리 최적화를 위해 TextureView 대신 SurfaceView 권장
  * 3D Rendering API Vulkan 지원
  * 업무 모드 끄기 기능

### Nougat 주요 기능
###### Multi-window support: 둘 이상의 앱을 동시에 표현하기 위한 신규 멀티태스킹 기능
  * adnroid:resizableActivity 라는 특성을 true로 설정하면 액티비티를 분할화면 모드에서 시작 가능
  * 화면 분할 모드에서 두 개의 앱을 좌우 또는 상하로 실행 가능
  * 앱 사이의 분할선을 끌어서 앱의 크기를 조정 가능
  * [Apps running in split-screen mode](https://developer.android.com/images/android-7.0/mw-splitscreen.png)

###### Notification Enhancements :
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
  * https://developer.android.com/about/versions/nougat/android-7.0.html#notification_enhancements

###### Profile-guided JIT/AOT Compilation
  * 프로필 가이드에 기반한 컴파일을 통해 AOT(Ahead-of-Time)컴파일 방식과 JIT(Just-in-Time)컴파일 방식을 혼용해서 쓸 수 있는 최적화 컴파일 제공
  * Android 4.4(Kikat)부터 별도의 스레드에서 프로파일링하여 사용빈도가 높은 메소드를 다시 컴파일하는 JIT 컴파일 방식과 유사한 기능이 도입됨
  * [참고한 글](http://realignist.me/code/2016/05/21/art-with-jit-compiler.html)

###### Doze on the Go... (이동 중 잠자기 모드)
  * Doze system mode 지원
  * 기기가 screen-off이거나 충전중이 아닌 경우 배터리 절약을 위해 앱에서 CPU와 Network 관련 액티비티 실행을 지연시킴

###### Background Optimization
  * 앱에서 사용하는 RAM크기를 최소화하기 위해 백그라운드 작업 수행 방식으로 JobScheduler와 GCMNetworkManager를 사용하도록 권장함

###### Data Saver :
  * 사용자가 Settings에서 Data Saver를 활성화하면 앱에 의해 사용되는 모바일 데이터 사용량 및 사용하는 방식을 제어할 수 있음.
  * [Data Saver in Settings](https://developer.android.com/images/android-7.0/datasaver.png)

###### Vulkan API
  * Vulkan(3D 그래픽 및 렌더링을 위한 공개 표준)를 통합한 새로운 3D 렌더링 API
  * CPU 오버 헤드를 최소화하도록 설계되었으며, 병렬 처리 성능을 높임
  * GPU 작업을 직접적으로 제어할 수 있는 API 제공
  * Vulkan 지원 하드웨어가 있는 기기에서만 사용 가능 ([Vulkan graphics API](https://developer.android.com/ndk/guides/graphics/index.html))
  * https://developer.android.com/about/versions/nougat/android-7.0.html#data_saver

###### Quick Settings Tile API
  * 드래그앤드랍으로 타일을 추가하거나 이동
  * 앱 개발자가 자신만의 Quick Settings 타일 정의 가능
  * [Quick Settings tiles in the notification shade](https://developer.android.com/about/versions/nougat/android-7.0.html#tile_api)

###### Number Blocking
  * 플랫폼에서 번호 차단을 지원
  * 통화에서 차단된 번호가 텍스트에서도 차단
  * 차단된 번호는 재설정 시에도 백업 및 복원 기능을 통해 기기에서 유지 가능
  * 여러 앱이 동일한 차단된 번호 목록 사용할 수 있음

###### Call Screening
  * 기본 전화 앱에서 원치 않는 통화를 차단하는 기능 제공
  * 수신 통화 거절
  * 통화 기록에서 제외
  * 통화 알림을 사용자에게 표시하지 않음

###### OpenGL™ ES 3.2 API 추가
  * OpenGL ES 3.2용 프레임워크 인터페이스와 플랫폼 지원

###### Android for Work
  * 업무 모드를 위한 프로필 및 보안 인증 질문 추가 가능
  * 업무 모드 설정 및 해제
  * 상시 접속 VPN : 지정된 VPN을 통해 업무모드용 앱을 연결하도록 지원
  * 사용자 지정 프로비저닝

###### Direct Boot
  * 기기에 전원이 들어와 있지만 사용자가 기기의 잠금을 해제하지 않을 경우, Direct Boot mode에서 Android가 실행됨
  * 이 모드에서는 알람/시계, SMS와 같은 사용자 알림, 접근성 서비스를 제공하는 기본 앱만 실행됨

###### Key Attestation
  * 하드웨어 기반 키 저장소 기능 제공

###### Network Security Config
  * X509TrustManager API를 활용하는 대신 res/xml/network_security_config.xml 에 선언하여 코드 수정없이 https/tls 연결 사용 가능

###### Default Trusted Certificate Authority
  * 사용자가 추가한 인증 기관(CA)을 사용하려면 Network Security Config 에 어떤 CA를 신뢰할 지 지정해야 함

###### APK Signature Scheme v2
  * 앱 설치 시간 단축, APK 파일은 무단 도용하지 못하도록 보호해주는 새로운 app-signing Scheme
  * build.gradle 파일에 android.signingConfigs.v25SigningEnabled 속성 추가됨

###### Scoped Directory Access
  * 앱에서 필요한 특정 외부 저장소 디렉토리만 액세스할 수 있도록 단순화된 API 제공
  * https://developer.android.com/training/articles/scoped-directory-access.html

###### Keyboard Shortcuts Helper
  * 화면에 맞춰 조정한 바로가기 목록 제공 지원

###### Sustained Performance API
  * Window.setSustainedPerformanceMode() 메소드를 사용하여 플래그를 설정한 앱에 기기 성능에 대한 힌트를 제공

###### FrameMetricsListener API
  * UI 렌더링 성능 모니터링
  * 성능 모니터링할 창에 FrameworkMetricsListener.onMetricsAvailable() 콜백 메서드를 UI에 구현

###### VR support
  * VR 모드에 대한 플랫폼 지원과 최적화

### 그 외 지원 기능
###### Multi-locale Support, More Languages
  * 검색 결과를 여러 언어로 표시하거나 사용자가 이미 알고 있는 언어로는 웹페이지를 번역하지 않는 등의 환경을 다중 로케일 사용자들에게 제공

###### New Emojis
  * skin tone emojis와 관련 기능을 추가 제공
  * http://unicode.org/emoji/charts/full-emoji-list.html

###### ICU4J APIs
  * icu4j.jar ? unicode and globalization support library for java
  * ICU4J API의 일부 기능을 android.icu API에서 제공

###### Accessibility Enhancements
  * 신규 기기 설치 시 Welcome 화면에서 Vision Settings를 바로 제공

###### Print Service Enhancements
  * 개별 프린터와 인쇄 작업에 대한 추가 정보 노출 (e.g 아이콘 설정, 프린터당 액티비티 제공, 인쇄 작업의 진행률 및 상태 표시)

###### Virtual Files
  * 저장소 액세스 프레임워크에서 바이트코드 표시가 없는 파일을 표시할 수 있는 DocumentsProvider를 제공
