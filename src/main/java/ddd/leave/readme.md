application: 应用层， 定义业务流程，非常薄的一层，用于编排业务。

common: 公共层

domain： 业务领域层，包含领域服务、领域值对象、领域实体对象、领域聚合根等。

infrastructure: 基础设施层 ， 包含Dao，Http，Rpc，Redis，等等远程服务的访问。

interfaces: 接口层，即访问层。


似乎原先的这个人的设计略有问题，不太符合层次说明信息。

如果将 dao层根据业务放入 domain层下， 则后面会混乱不堪，而且对于包的单一职责显得很混乱。

遵循分离领域涉及模型：
![image](https://i.loli.net/2021/07/28/ltKk4qpgyQscB2D.png)
