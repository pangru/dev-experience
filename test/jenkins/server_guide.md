1. Install android sdk on Ubuntu
http://stackoverflow.com/questions/17963508/how-to-install-android-sdk-build-tools-on-the-command-line
By default, the SDK Manager from the command line does not include the build tools in the list. They're in the "obsolete" category. To see all available downloads, use

android list sdk --all
And then to get one of the packages in that list from the command line, use:

android update sdk -u -a -t <package no.>
Where -u stands for --no-ui, -a stands for --all and -t stands for --filter.

If you need to install multiple packages do:

android update sdk -u -a -t 1,2,3,4,..,n
Where 1,2,..,n is the package number listed with the list command above


2. Install Java on Ubuntu
http://sarghis.com/blog/1050/
