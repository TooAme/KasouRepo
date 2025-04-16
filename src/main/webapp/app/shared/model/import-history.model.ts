export interface IImportHistory {
  id?: number;
  uuid?: string;
  tcihCode?: string | null;
  tcihFilename?: string | null;
  tcihImporttime?: Date | null;
  tcihStatus?: boolean | null;
  createBy?: string | null;
  createTime?: Date | null;
  updateBy?: string | null;
  updateTime?: Date | null;
  delFlag?: boolean | null;
  remark?: string | null;
}

export class ImportHistory implements IImportHistory {
  constructor(
    public id?: number,
    public uuid?: string,
    public tcihCode?: string | null,
    public tcihFilename?: string | null,
    public tcihImporttime?: Date | null,
    public tcihStatus?: boolean | null,
    public createBy?: string | null,
    public createTime?: Date | null,
    public updateBy?: string | null,
    public updateTime?: Date | null,
    public delFlag?: boolean | null,
    public remark?: string | null,
  ) {
    this.tcihStatus = this.tcihStatus ?? false;
    this.delFlag = this.delFlag ?? false;
  }
}
