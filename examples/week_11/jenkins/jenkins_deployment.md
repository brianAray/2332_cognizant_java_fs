# Jenkins Guide

## Infrastructure Preparation

### 1 - S3 Bucket

1. Go to S3 Console and create a bucket
2. Give it a unique name and save it somewhere
3. Uncheck `Block all public access`
4. Go to `Properties` -> `Static website hosting` -> Enable
    - Index document: `index.html`
5. Go to `Permissions` -> `Bucket policy`:

```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "PublicReadGetObject",
            "Effect": "Allow",
            "Principal": "*",
            "Action": "s3:GetObject",
            "Resource": "arn:aws:s3:::<YOUR_BUCKET_NAME>/*"
        }
    ]
}
```


### 2 - Launch Application EC2

1. Launch an EC2 instance (Amazon Linux 2023) and choose free tier
2. Name: `app-server`
3. Security group: Allow `SSH (22)` and `HTTP (80)` from everywhere
4. Key Pair: Create one and save it somewhere
5. Wait for it to launch, save the public IP
6. Connect to the instance using the AWS Console

```bash
sudo yum update -y
sudo install docker -y
sudo service docker start
sudo usermod -a -G docker ec2-user
```


### 3 - Launch Jenkins EC2

1. Launch an EC2 instance (Amazon Linux 2023) and choose free tier
2. Name: `jenkins-server`
3. Security Group: Allow `SSH (22)` and `HTTP (80)` from everywhere
4. Wait for it to launch and save its public IP
5. Connect to the instance using the AWS Console

```bash
sudo dnf update -y
sudo dnf install java-17-amazon-corretto -y

sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io-2023.key
sudo dnf install jenkins -y
sudo systemctl enable jenkins
```

#### Jenkins Port Update

- In editor

```bash
[Service]
Environment="JENKINS_PORT=80"
AmbientCapabilities=CAP_NET_BIND_SERVICE
```
- To save and exit: `Ctrl+O`, `Enter`, `Ctrl+X`

- Continue the jenkins setup

```bash
sudo systemctl daemon-reload
sudo systemctl start jenkins
sudo dnf install git -y
```

#### Swap Setup

```bash
# Create 2GB swap file
sudo dd if=/dev/zero of=/swapfile bs=1M count=2048
sudo chmod 600 /swapfile
sudo mkswap /swapfile
sudo swapon /swapfile
echo '/swapfile none swap sw 0 0' | sudo tee -a /etc/fstab

# Resize /tmp to use swap (prevent "No space left on device" errors)
sudo mount -o remount,size=2G,noatime /tmp
```

### 4 - Jenkins Configuration

1. In the Jenkins EC2 run and save it: `sudo cat /var/lib/jenkins/secrets/initialAdminPassword`
2. Access Jenkins at `http://<JENKINS_IP>:80`
3. Install Suggested Plugins
3. Install additional plugins:
    - Go to `Manage Jenkins` -> `Plugins`
    - Install:
        - `NodeJS Plugin`
        - `Pipeline: AWS Steps`
        - `SSH Agent`
4. Configure Tools:
    - Go to `Manage Jenkins` -> `Tools`
    - Maven
        - Add Maven
        - Name it `Maven 3.9.12`
        - Check install automatically
        - Choose the version of Maven that matches the name
    - NodeJS
        - Add NodeJS
        - Name it `NodeJS 24`
        - Check install automatically
        - Choose the version of NodeJS that matches the name
5. Configure Credentials
    - AWS Credentials
        - ID: `aws-credentials`
        - Add your AWS Access Key and Secret Key
    - SSH Key
        - ID: `app-server-ssh-key`
        - username: `ec2-user`
        - Paste in the contents of the `.pem` file for the `app-server`

### 5 - Running the Pipeline

1. Create new job
    - Type: `Pipeline`
2. Pipeline Config
    - Github Project
    - Pipeline script from SCM
    - SCM: `Git`
        - Repository URL
        - Script Path
3. Make sure you update the `Jenkinsfile` in your repo to match the right variables for your services
4. Build now