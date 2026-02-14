declare module '@apiverve/savingsbonds' {
  export interface savingsbondsOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface savingsbondsResponse {
    status: string;
    error: string | null;
    data: SavingsBondsData;
    code?: number;
  }


  interface SavingsBondsData {
      iBonds:               IBonds;
      eeBonds:              EeBonds;
      recommendation:       string;
      recommendationReason: string;
      nextRateChange:       Date;
      lastUpdated:          Date;
  }
  
  interface EeBonds {
      currentRate:        number;
      guaranteedDoubling: string;
      purchaseLimit:      number;
  }
  
  interface IBonds {
      currentRate:   number;
      fixedRate:     number;
      inflationRate: number;
      purchaseLimit: number;
  }

  export default class savingsbondsWrapper {
    constructor(options: savingsbondsOptions);

    execute(callback: (error: any, data: savingsbondsResponse | null) => void): Promise<savingsbondsResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: savingsbondsResponse | null) => void): Promise<savingsbondsResponse>;
    execute(query?: Record<string, any>): Promise<savingsbondsResponse>;
  }
}
