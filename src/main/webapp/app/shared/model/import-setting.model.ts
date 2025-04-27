export interface IImportSetting {
  id?: number;
  tcisCode?: string | null;
  tcisType?: string | null;
  tcisIncol?: string | null;
  tcisEditrule?: string | null;
}

export class ImportSetting implements IImportSetting {
  constructor(
    public id?: number,
    public tcisCode?: string | null,
    public tcisType?: string | null,
    public tcisIncol?: string | null,
    public tcisEditrule?: string | null,
  ) {}
}
