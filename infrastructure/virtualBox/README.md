### 手动安装java8
可以参考:https://github.com/OpenTreeOfLife/germinator/wiki/Debian-upgrade-notes:-jessie-and-openjdk-8

### 手动安装docker-compose
```
sudo apt-get install software-properties-common
sudo pip install docker-compose
```

### 手动安装vim
```
sudo apt-get install vim
```

### 出现SSH错误

#### Option 1
在本机的`known_hosts`中删除已有的192.168.33.80。
把本机的`public key`粘贴到虚拟机`authorised_key`里面

#### Option 2
```
ssh-keygen -R 192.168.33.80
cat ~/.ssh/id_rsa.pub | ssh vagrant@192.168.33.80 "grep . >> .ssh/authorized_keys"
```

#### Option 3
```
ansible -i hosts all -m copy -a 'src=~/.ssh/id_rsa.pub dest=~' -k
ansible -i hosts all -m shell -a 'mkdir -p .ssh' -k
ansible -i hosts all -m shell -a 'cat ~/id_rsa.pub >>  ~/.ssh/authorized_keys' -k
```
