# 时光花园 (ChronoGarden)

[![Vue.js](https://img.shields.io/badge/Vue.js-3.x-4FC08D?logo=vue.js)](https://vuejs.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-6DB33F?logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Element Plus](https://img.shields.io/badge/Element%20Plus-latest-409EFF?logo=element)](https://element-plus.org/)
[![ECharts](https://img.shields.io/badge/ECharts-5.x-AA344D?logo=apache-echarts)](https://echarts.apache.org/)

时光花园是一个植物培育模拟系统，让用户可以体验培养珍稀植物的乐趣，通过精心照料使其完成从种子到结果的完整生长周期。

## 🌱 项目概述

时光花园模拟了植物生长的自然规律，用户需要通过合理调配水分、光照和养分三项基本要素，应对随机天气事件，让植物健康成长。每种植物都有独特的生长周期和照料需求，成功培育一株植物将获得成就感和虚拟奖励。

## 🌟 核心功能

- **植物图鉴**：浏览可领养的珍稀植物品种
- **我的花园**：管理已领养的植物，进行养护操作
- **养护操作**：浇水、光照调节、施肥、修剪等多种养护方式
- **生长周期**：植物从种子、发芽、开花到结果的完整生长过程
- **随机事件**：应对干旱、虫害、寒潮等突发情况
- **养护记录**：详细记录每个养护操作和系统事件
- **状态可视化**：使用ECharts图表展示植物状态变化历史
- **深色模式**：支持浅色/深色主题自动切换

## 🔧 技术栈

### 前端

- Vue.js 3 (Composition API)
- Vite 构建工具
- Element Plus UI框架
- Axios HTTP客户端
- ECharts 数据可视化
- CSS变量实现主题切换

### 后端

- Spring Boot 3.3.5
- Spring Data JPA
- MySQL数据库
- Spring Security
- Spring Scheduled Tasks
- RESTful API设计

## 📦 安装与部署

### 系统要求

- Node.js 16+
- JDK 11+
- Maven 3.6+
- MySQL 8+ 

### 前端部署

```bash
# 克隆仓库
git clone https://github.com/buynonsense/chronogarden-frontend.git
cd chronogarden-frontend

# 安装依赖
npm install

# 开发模式启动
npm run dev

# 生产环境构建
npm run build
```

### 后端部署

```bash
# 克隆仓库
git clone https://github.com/buynonsense/ChronoGarden.git
cd ChronoGarden

# 使用Maven构建
mvn clean package
```

## 🌿 使用指南

### 初次使用

1. 注册账号并登录系统
2. 浏览【植物图鉴】，选择感兴趣的植物品种
3. 点击"领养植物"将其添加到您的花园
4. 在【我的花园】中开始养护您的植物

### 养护技巧

- **水分管理**：定期浇水，避免过度浇灌或干旱
- **光照管理**：调整光照保持在适当水平
- **养分管理**：视植物需求适时施肥
- **修剪**：在适当时机进行修剪，促进植物健康生长
- **应对随机事件**：根据事件类型及时采取相应措施

## 📊 数据可视化

时光花园提供基于ECharts的植物状态可视化功能，帮助用户:

- 监控植物水分、光照、养分随时间的变化趋势
- 了解不同养护操作对植物状态的影响
- 分析植物生长周期的转变节点
- 更科学地规划养护策略

## 🏗️ 系统架构

```
时光花园
├── 前端 (Vue.js)
│   ├── 视图组件
│   │   ├── 植物图鉴
│   │   ├── 我的花园
│   │   ├── 植物详情
│   │   └── 养护记录
│   ├── 公共组件
│   │   ├── 植物卡片
│   │   ├── 状态进度条
│   │   ├── 生长阶段标识
│   │   └── 数据可视化图表
│   └── 服务/工具
│       ├── API调用
│       ├── 用户认证
│       └── 主题切换
│
└── 后端 (Spring Boot)
    ├── 控制器
    │   ├── 植物控制器
    │   ├── 用户控制器
    │   └── 养护记录控制器
    ├── 服务
    │   ├── 植物生长服务
    │   ├── 养护记录服务
    │   └── 用户服务
    ├── 调度器
    │   ├── 正常衰减调度器
    │   └── 随机事件调度器
    ├── 模型
    │   ├── 植物
    │   ├── 用户
    │   └── 养护记录
    └── 数据访问
        └── JPA存储库
```

## 👨‍💻 开发指南

### 前端开发

- 组件遵循单一职责原则
- 使用Composition API组织逻辑
- 确保所有UI组件正确响应深色模式
- 良好的移动端界面适配
- 使用CSS变量统一管理主题样式

### 后端开发

- 遵循RESTful API设计原则
- 使用事务确保数据一致性
- 编写单元测试覆盖核心逻辑
- 使用日志记录关键操作

## 🤝 贡献指南

欢迎为时光花园项目做出贡献！您可以通过以下方式参与:

1. 提交bug报告或功能请求
2. 审查代码并提出改进建议
3. 编写或改进文档
4. 提交新功能或修复PR

请确保您的代码符合项目的编码规范，并已通过单元测试。

## 📜 许可证

本项目采用 MIT 许可证。详情请参阅 LICENSE 文件。

## 📧 联系方式

如有任何问题或建议，请通过以下方式联系我:

- Email: buytothenonsense@outlook.com
- GitHub Issues: [提交问题](https://github.com/buynonsense/ChronoGarden/issues)

---

祝您在时光花园中享受培育珍稀植物的奇妙旅程！🌷
