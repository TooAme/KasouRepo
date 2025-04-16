export interface ISSImport {
  id?: number;
  uuid?: string;
  ssCreateBy?: string | null;
  ssFilename?: string | null;
  ssBCode?: string | null;
  ssSubBCode?: string | null;
  createBy?: string | null;
  createTime?: Date | null;
  updateBy?: string | null;
  updateTime?: Date | null;
  delFlag?: boolean | null;
  remark?: string | null;
}

export class SSImport implements ISSImport {
  constructor(
    public id?: number,
    public uuid?: string,
    public ssCreateBy?: string | null,
    public ssFilename?: string | null,
    public ssBCode?: string | null,
    public ssSubBCode?: string | null,
    public createBy?: string | null,
    public createTime?: Date | null,
    public updateBy?: string | null,
    public updateTime?: Date | null,
    public delFlag?: boolean | null,
    public remark?: string | null,
  ) {
    this.delFlag = this.delFlag ?? false;
  }
}
