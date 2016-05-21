Option 1

known_hosts 删除已有的192.168.33.80。

把本机的public key粘贴到虚拟机authorised_key里面



Option 2
ssh-keygen -R 192.168.33.80
cat ~/.ssh/id_rsa.pub | ssh vagrant@192.168.33.80 "grep . >> .ssh/authorized_keys"


Option 3

ansible -i hosts all -m copy -a 'src=~/.ssh/id_rsa.pub dest=~' -k

ansible -i hosts all -m shell -a 'mkdir -p .ssh' -k

ansible -i hosts all -m shell -a 'cat ~/id_rsa.pub >>  ~/.ssh/authorized_keys' -k

