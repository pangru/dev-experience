# Continuous Integration Server
엔지니어가 Git 저장소에 push하면, 소스 코드와 테스트 코드를 빌드하고, 빌드 결과를 사용자에게 메일 발송한다. 성공한 빌드 결과물(.APK)을 배포합니다.

## Introduction
## Devops?
엔지니어가, 프로그래밍하고, 빌드하고, 직접 시스템에 배포 및 서비스를 RUN한다. 그리고, 사용자와 끊임 없이 Interaction하면서 서비스를 개선해 나가는 일련의 과정이자 문화이다. 아래 그림은, devops 문화를 가져가기 위해 필요한 구성 요소와 프로세스를 나타냅니다.
![Devops process](https://insights.sei.cmu.edu/assets/content/image%20for%20continuous%20integration%20and%20devops_01262015.jpg)

#### oracle에서 권장하고 있는 Java 개발 프로세스
![](http://www.oracle.com/technetwork/articles/java/deployment-illo-2228199.jpg =250px)

## Jenkins 설치 및 실행
Jenkins 서버를 설치하는 방법에는 톰캣 등의 WAS와 함께 설치하거나, Jenkins WAR 파일을 직접 실행하는 방법이 있습니다.
본 문서에서는 Jenkins WAR 파일을 직접 실행하는 방법을 위주로 설명하고 있습니다.

1. [Jenkins 홈페이지](https://jenkins.io)에서 WAR 파일 다운로드
2. /etc/init.d/jenkins 파일 생성
3. chmod a+x /etc/init.d/jenkins 실행모드 변경
4. update-rc.d jenkins defaults (서버부팅 스크립트에 jenkins 추가)

임의로 Jenkins 서버 상태를 변경하고 싶은 경우,
```
$ /etc/init.d/jenkins [ start | restart | stop ]
```
자세한 설치 및 실행 방법: [Installing Jenkins as a Unix daemon](https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+as+a+Unix+daemon)


## Build Trigger
Git 저장소에 변경점이 발생하면 변경사항을 Jenkins 서버로 바로 전달할 수 있도록 Gogs 서버에 Webhook을 등록합니다.
Jenkins 서버에서 커밋 알림을 받으면 자동으로 해당 프로젝트가 빌드됩니다.
이러한 설정을 위해 gogs 페이지에서 먼저 webhook을 등록해야 합니다.
![](webhooking.png)


## Build deployment
빌드될 때마다 apk 파일이 생성되도록 프로젝트 설정을 추가 합니다.
### Todo
* apk 관리 기준 필요
* Tag(앱 릴리즈) 생성 시마다 Apk파일 생성하는 별도 프로젝트 생성?


## future work
- 인증
- CLM 연동?
- 빌드 실패 시, committer에서 자동 메일 발송
- 빌드 script 구성
- UI 자동화 테스트 방법


## Reference
- [Devops](https://insights.sei.cmu.edu/devops/2015/01/continuous-integration-in-devops-1.html)
- [Open Source Tools for Java Development](http://www.oracle.com/technetwork/articles/java/deployment-tools-2227133.html)
- [comparison of continuous intagration software](https://en.wikipedia.org/wiki/Comparison_of_continuous_integration_software)
- [How to install android-sdk on Linux](https://www.digitalocean.com/community/tutorials/how-to-build-android-apps-with-jenkins)
- [continuous integration best practice](https://simpleprogrammer.com/2009/12/30/continuous-integration-best-practices/)
- [Android build guide](https://www.davidlab.net/ko/tech/how-to-build-android-apps-with-jenkins/)
